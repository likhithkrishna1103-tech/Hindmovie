package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
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
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.material.internal.CheckableImageButton;
import da.c;
import da.d0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import k9.b;
import k9.d;
import k9.j;
import k9.k;
import ka.g;
import ka.i;
import ka.m;
import l5.h;
import nc.l;
import o.a1;
import o.n1;
import o.r;
import pa.a0;
import pa.b0;
import pa.n;
import pa.p;
import pa.s;
import pa.t;
import pa.v;
import pa.x;
import pa.y;
import pa.z;
import ra.a;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int Y0 = k.Widget_Design_TextInputLayout;
    public static final int[][] Z0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public CharSequence A;
    public final LinkedHashSet A0;
    public int B;
    public ColorDrawable B0;
    public int C;
    public int C0;
    public int D;
    public Drawable D0;
    public int E;
    public ColorStateList E0;
    public final t F;
    public ColorStateList F0;
    public boolean G;
    public int G0;
    public int H;
    public int H0;
    public boolean I;
    public int I0;
    public a0 J;
    public ColorStateList J0;
    public a1 K;
    public int K0;
    public int L;
    public int L0;
    public int M;
    public int M0;
    public CharSequence N;
    public int N0;
    public boolean O;
    public int O0;
    public a1 P;
    public int P0;
    public ColorStateList Q;
    public boolean Q0;
    public int R;
    public final c R0;
    public h S;
    public boolean S0;
    public h T;
    public boolean T0;
    public ColorStateList U;
    public ValueAnimator U0;
    public ColorStateList V;
    public boolean V0;
    public ColorStateList W;
    public boolean W0;
    public boolean X0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ColorStateList f2964a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2965b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f2966c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2967d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public i f2968e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public i f2969f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public StateListDrawable f2970g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2971h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public i f2972i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public i f2973j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public m f2974k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f2975l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final int f2976m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f2977n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f2978p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f2979q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f2980r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f2981s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f2982t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Rect f2983u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FrameLayout f2984v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final Rect f2985v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x f2986w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final RectF f2987w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f2988x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public Typeface f2989x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2990y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ColorDrawable f2991y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public EditText f2992z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f2993z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int i = b.textInputStyle;
        int i10 = Y0;
        super(a.a(context, attributeSet, i, i10), attributeSet, i);
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = new t(this);
        this.J = new l(5);
        this.f2983u0 = new Rect();
        this.f2985v0 = new Rect();
        this.f2987w0 = new RectF();
        this.A0 = new LinkedHashSet();
        c cVar = new c(this);
        this.R0 = cVar;
        this.X0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2984v = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = l9.a.f7925a;
        cVar.R = linearInterpolator;
        cVar.j(false);
        cVar.Q = linearInterpolator;
        cVar.j(false);
        if (cVar.f3584g != 8388659) {
            cVar.f3584g = 8388659;
            cVar.j(false);
        }
        int[] iArr = k9.l.TextInputLayout;
        int[] iArr2 = {k9.l.TextInputLayout_counterTextAppearance, k9.l.TextInputLayout_counterOverflowTextAppearance, k9.l.TextInputLayout_errorTextAppearance, k9.l.TextInputLayout_helperTextTextAppearance, k9.l.TextInputLayout_hintTextAppearance};
        d0.a(context2, attributeSet, i, i10);
        d0.b(context2, attributeSet, iArr, i, i10, iArr2);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, i10);
        l7.a aVar = new l7.a(context2, typedArrayObtainStyledAttributes);
        x xVar = new x(this, aVar);
        this.f2986w = xVar;
        this.f2965b0 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_hintEnabled, true);
        setHint(typedArrayObtainStyledAttributes.getText(k9.l.TextInputLayout_android_hint));
        this.T0 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_hintAnimationEnabled, true);
        this.S0 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_expandedHintEnabled, true);
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_android_minEms)) {
            setMinEms(typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_android_minEms, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_android_minWidth)) {
            setMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.TextInputLayout_android_minWidth, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_android_maxEms)) {
            setMaxEms(typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_android_maxEms, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_android_maxWidth)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.TextInputLayout_android_maxWidth, -1));
        }
        this.f2974k0 = m.c(context2, attributeSet, i, i10).a();
        this.f2976m0 = context2.getResources().getDimensionPixelOffset(d.mtrl_textinput_box_label_cutout_padding);
        this.o0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(k9.l.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f2990y = getResources().getDimensionPixelSize(d.m3_multiline_hint_filled_text_extra_space);
        this.f2979q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(d.mtrl_textinput_box_stroke_width_default));
        this.f2980r0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(d.mtrl_textinput_box_stroke_width_focused));
        this.f2978p0 = this.f2979q0;
        float dimension = typedArrayObtainStyledAttributes.getDimension(k9.l.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(k9.l.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(k9.l.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(k9.l.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ka.l lVarG = this.f2974k0.g();
        if (dimension >= 0.0f) {
            lVarG.f7343e = new ka.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            lVarG.f = new ka.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            lVarG.f7344g = new ka.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            lVarG.f7345h = new ka.a(dimension4);
        }
        this.f2974k0 = lVarG.a();
        ColorStateList colorStateListJ = com.bumptech.glide.c.j(context2, aVar, k9.l.TextInputLayout_boxBackgroundColor);
        if (colorStateListJ != null) {
            int defaultColor = colorStateListJ.getDefaultColor();
            this.K0 = defaultColor;
            this.f2982t0 = defaultColor;
            if (colorStateListJ.isStateful()) {
                this.L0 = colorStateListJ.getColorForState(new int[]{-16842910}, -1);
                this.M0 = colorStateListJ.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.N0 = colorStateListJ.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.M0 = this.K0;
                ColorStateList colorStateListC = i0.c.c(context2, k9.c.mtrl_filled_background_color);
                this.L0 = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                this.N0 = colorStateListC.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f2982t0 = 0;
            this.K0 = 0;
            this.L0 = 0;
            this.M0 = 0;
            this.N0 = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListR = aVar.r(k9.l.TextInputLayout_android_textColorHint);
            this.F0 = colorStateListR;
            this.E0 = colorStateListR;
        }
        ColorStateList colorStateListJ2 = com.bumptech.glide.c.j(context2, aVar, k9.l.TextInputLayout_boxStrokeColor);
        this.I0 = typedArrayObtainStyledAttributes.getColor(k9.l.TextInputLayout_boxStrokeColor, 0);
        this.G0 = context2.getColor(k9.c.mtrl_textinput_default_box_stroke_color);
        this.O0 = context2.getColor(k9.c.mtrl_textinput_disabled_color);
        this.H0 = context2.getColor(k9.c.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListJ2 != null) {
            setBoxStrokeColorStateList(colorStateListJ2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(com.bumptech.glide.c.j(context2, aVar, k9.l.TextInputLayout_boxStrokeErrorColor));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_hintTextAppearance, 0));
        }
        this.W = aVar.r(k9.l.TextInputLayout_cursorColor);
        this.f2964a0 = aVar.r(k9.l.TextInputLayout_cursorErrorColor);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_errorTextAppearance, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(k9.l.TextInputLayout_errorContentDescription);
        int i11 = typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_errorEnabled, false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_helperTextTextAppearance, 0);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(k9.l.TextInputLayout_helperText);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(k9.l.TextInputLayout_placeholderText);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_counterMaxLength, -1));
        this.M = typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_counterTextAppearance, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(k9.l.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i11);
        setCounterOverflowTextAppearance(this.L);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.M);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_errorTextColor)) {
            setErrorTextColor(aVar.r(k9.l.TextInputLayout_errorTextColor));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(aVar.r(k9.l.TextInputLayout_helperTextTextColor));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_hintTextColor)) {
            setHintTextColor(aVar.r(k9.l.TextInputLayout_hintTextColor));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_counterTextColor)) {
            setCounterTextColor(aVar.r(k9.l.TextInputLayout_counterTextColor));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(aVar.r(k9.l.TextInputLayout_counterOverflowTextColor));
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(aVar.r(k9.l.TextInputLayout_placeholderTextColor));
        }
        p pVar = new p(this, aVar);
        this.f2988x = pVar;
        boolean z13 = typedArrayObtainStyledAttributes.getBoolean(k9.l.TextInputLayout_android_enabled, true);
        setHintMaxLines(typedArrayObtainStyledAttributes.getInt(k9.l.TextInputLayout_hintMaxLines, 1));
        aVar.G();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(xVar);
        frameLayout.addView(pVar);
        addView(frameLayout);
        setEnabled(z13);
        setHelperTextEnabled(z11);
        setErrorEnabled(z10);
        setCounterEnabled(z12);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f2992z;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.f2968e0;
        }
        int iN = f.n(this.f2992z, g.a.colorControlHighlight);
        int i = this.f2977n0;
        int[][] iArr = Z0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            i iVar = this.f2968e0;
            int i10 = this.f2982t0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{f.D(0.1f, iN, i10), i10}), iVar, iVar);
        }
        Context context = getContext();
        i iVar2 = this.f2968e0;
        TypedValue typedValueI = android.support.v4.media.session.b.I(b.colorSurface, context, "TextInputLayout");
        int i11 = typedValueI.resourceId;
        int color = i11 != 0 ? context.getColor(i11) : typedValueI.data;
        i iVar3 = new i(iVar2.f7334w.f7316a);
        int iD = f.D(0.1f, iN, color);
        iVar3.q(new ColorStateList(iArr, new int[]{iD, 0}));
        iVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iD, color});
        i iVar4 = new i(iVar2.f7334w.f7316a);
        iVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar3, iVar4), iVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f2970g0 == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2970g0 = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f2970g0.addState(new int[0], h(false));
        }
        return this.f2970g0;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f2969f0 == null) {
            this.f2969f0 = h(true);
        }
        return this.f2969f0;
    }

    public static void m(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f2992z != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f2992z = editText;
        int i = this.B;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.D);
        }
        int i10 = this.C;
        if (i10 != -1) {
            setMaxEms(i10);
        } else {
            setMaxWidth(this.E);
        }
        this.f2971h0 = false;
        k();
        setTextInputAccessibilityDelegate(new z(this));
        Typeface typeface = this.f2992z.getTypeface();
        c cVar = this.R0;
        cVar.n(typeface);
        float textSize = this.f2992z.getTextSize();
        if (cVar.f3586h != textSize) {
            cVar.f3586h = textSize;
            cVar.j(false);
        }
        float letterSpacing = this.f2992z.getLetterSpacing();
        if (cVar.X != letterSpacing) {
            cVar.X = letterSpacing;
            cVar.j(false);
        }
        int gravity = this.f2992z.getGravity();
        int i11 = (gravity & (-113)) | 48;
        if (cVar.f3584g != i11) {
            cVar.f3584g = i11;
            cVar.j(false);
        }
        if (cVar.f != gravity) {
            cVar.f = gravity;
            cVar.j(false);
        }
        this.P0 = editText.getMinimumHeight();
        this.f2992z.addTextChangedListener(new y(this, editText));
        if (this.E0 == null) {
            this.E0 = this.f2992z.getHintTextColors();
        }
        if (this.f2965b0) {
            if (TextUtils.isEmpty(this.f2966c0)) {
                CharSequence hint = this.f2992z.getHint();
                this.A = hint;
                setHint(hint);
                this.f2992z.setHint((CharSequence) null);
            }
            this.f2967d0 = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        if (this.K != null) {
            p(this.f2992z.getText());
        }
        t();
        this.F.b();
        this.f2986w.bringToFront();
        p pVar = this.f2988x;
        pVar.bringToFront();
        Iterator it = this.A0.iterator();
        while (it.hasNext()) {
            ((n) it.next()).a(this);
        }
        pVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f2966c0)) {
            return;
        }
        this.f2966c0 = charSequence;
        c cVar = this.R0;
        if (charSequence == null || !TextUtils.equals(cVar.B, charSequence)) {
            cVar.B = charSequence;
            cVar.C = null;
            cVar.j(false);
        }
        if (this.Q0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.O == z10) {
            return;
        }
        if (z10) {
            a1 a1Var = this.P;
            if (a1Var != null) {
                this.f2984v.addView(a1Var);
                this.P.setVisibility(0);
            }
        } else {
            a1 a1Var2 = this.P;
            if (a1Var2 != null) {
                a1Var2.setVisibility(8);
            }
            this.P = null;
        }
        this.O = z10;
    }

    public final void a() {
        if (this.f2992z == null || this.f2977n0 != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.f2992z;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.R0.f() + this.f2990y), this.f2992z.getPaddingEnd(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.f2992z;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_2_0_padding_top), this.f2992z.getPaddingEnd(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_2_0_padding_bottom));
        } else if (com.bumptech.glide.c.z(getContext())) {
            EditText editText3 = this.f2992z;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_1_3_padding_top), this.f2992z.getPaddingEnd(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f2984v;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f) {
        c cVar = this.R0;
        if (cVar.f3575b == f) {
            return;
        }
        int i = 1;
        if (this.U0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.U0 = valueAnimator;
            valueAnimator.setInterpolator(sd.i.D(getContext(), b.motionEasingEmphasizedInterpolator, l9.a.f7926b));
            this.U0.setDuration(sd.i.C(getContext(), b.motionDurationMedium4, 167));
            this.U0.addUpdateListener(new oa.b(i, this));
        }
        this.U0.setFloatValues(cVar.f3575b, f);
        this.U0.start();
    }

    public final void c() {
        int i;
        int i10;
        i iVar = this.f2968e0;
        if (iVar == null) {
            return;
        }
        m mVar = iVar.f7334w.f7316a;
        m mVar2 = this.f2974k0;
        if (mVar != mVar2) {
            iVar.setShapeAppearanceModel(mVar2);
        }
        if (this.f2977n0 == 2 && (i = this.f2978p0) > -1 && (i10 = this.f2981s0) != 0) {
            i iVar2 = this.f2968e0;
            iVar2.f7334w.f7324k = i;
            iVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
            g gVar = iVar2.f7334w;
            if (gVar.f7320e != colorStateListValueOf) {
                gVar.f7320e = colorStateListValueOf;
                iVar2.onStateChange(iVar2.getState());
            }
        }
        int iB = this.f2982t0;
        if (this.f2977n0 == 1) {
            iB = l0.b.b(this.f2982t0, f.m(getContext(), b.colorSurface, 0));
        }
        this.f2982t0 = iB;
        this.f2968e0.q(ColorStateList.valueOf(iB));
        i iVar3 = this.f2972i0;
        if (iVar3 != null && this.f2973j0 != null) {
            if (this.f2978p0 > -1 && this.f2981s0 != 0) {
                iVar3.q(this.f2992z.isFocused() ? ColorStateList.valueOf(this.G0) : ColorStateList.valueOf(this.f2981s0));
                this.f2973j0.q(ColorStateList.valueOf(this.f2981s0));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.f2992z == null) {
            throw new IllegalStateException();
        }
        boolean z10 = getLayoutDirection() == 1;
        int i = rect.bottom;
        Rect rect2 = this.f2985v0;
        rect2.bottom = i;
        int i10 = this.f2977n0;
        if (i10 == 1) {
            rect2.left = i(rect.left, z10);
            rect2.top = rect.top + this.o0;
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        if (i10 != 2) {
            rect2.left = i(rect.left, z10);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        rect2.left = this.f2992z.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.f2992z.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f2992z;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.A != null) {
            boolean z10 = this.f2967d0;
            this.f2967d0 = false;
            CharSequence hint = editText.getHint();
            this.f2992z.setHint(this.A);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f2992z.setHint(hint);
                this.f2967d0 = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.f2984v;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i10 = 0; i10 < frameLayout.getChildCount(); i10++) {
            View childAt = frameLayout.getChildAt(i10);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i10);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.f2992z) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.W0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.W0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        i iVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z10 = this.f2965b0;
        c cVar = this.R0;
        if (z10) {
            TextPaint textPaint = cVar.O;
            RectF rectF = cVar.f3581e;
            int iSave = canvas2.save();
            if (cVar.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(cVar.G);
                float f = cVar.f3598q;
                float f10 = cVar.f3599r;
                float f11 = cVar.F;
                if (f11 != 1.0f) {
                    canvas2.scale(f11, f11, f, f10);
                }
                if ((cVar.f3582e0 > 1 || cVar.f3583f0 > 1) && !cVar.D && cVar.o()) {
                    float lineStart = cVar.f3598q - cVar.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f10);
                    float f12 = alpha;
                    textPaint.setAlpha((int) (cVar.f3578c0 * f12));
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        float f13 = cVar.H;
                        float f14 = cVar.I;
                        float f15 = cVar.J;
                        int i10 = cVar.K;
                        textPaint.setShadowLayer(f13, f14, f15, l0.b.d(i10, (textPaint.getAlpha() * Color.alpha(i10)) / 255));
                    }
                    cVar.Z.draw(canvas2);
                    textPaint.setAlpha((int) (cVar.f3576b0 * f12));
                    if (i >= 31) {
                        float f16 = cVar.H;
                        float f17 = cVar.I;
                        float f18 = cVar.J;
                        int i11 = cVar.K;
                        textPaint.setShadowLayer(f16, f17, f18, l0.b.d(i11, (Color.alpha(i11) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = cVar.Z.getLineBaseline(0);
                    CharSequence charSequence = cVar.f3580d0;
                    float f19 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f19, textPaint);
                    if (i >= 31) {
                        textPaint.setShadowLayer(cVar.H, cVar.I, cVar.J, cVar.K);
                    }
                    String strTrim = cVar.f3580d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(cVar.Z.getLineEnd(0), str.length()), 0.0f, f19, (Paint) textPaint);
                } else {
                    canvas2.translate(f, f10);
                    cVar.Z.draw(canvas2);
                }
                canvas2.restoreToCount(iSave);
            }
        }
        if (this.f2973j0 == null || (iVar = this.f2972i0) == null) {
            return;
        }
        iVar.draw(canvas2);
        if (this.f2992z.isFocused()) {
            Rect bounds = this.f2973j0.getBounds();
            Rect bounds2 = this.f2972i0.getBounds();
            float f20 = cVar.f3575b;
            int iCenterX = bounds2.centerX();
            bounds.left = l9.a.c(f20, iCenterX, bounds2.left);
            bounds.right = l9.a.c(f20, iCenterX, bounds2.right);
            this.f2973j0.draw(canvas2);
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
            boolean r0 = r4.V0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.V0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            da.c r3 = r4.R0
            if (r3 == 0) goto L2f
            r3.M = r1
            android.content.res.ColorStateList r1 = r3.f3591k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f3589j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.j(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f2992z
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = r2
        L42:
            r4.w(r0, r2)
        L45:
            r4.t()
            r4.z()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.V0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.f2965b0) {
            int i = this.f2977n0;
            c cVar = this.R0;
            if (i == 0) {
                return (int) cVar.f();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (cVar.f() / 2.0f);
                }
                float f = cVar.f();
                TextPaint textPaint = cVar.P;
                textPaint.setTextSize(cVar.i);
                textPaint.setTypeface(cVar.f3600s);
                textPaint.setLetterSpacing(cVar.W);
                return Math.max(0, (int) (f - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final h f() {
        h hVar = new h();
        hVar.f7816x = sd.i.C(getContext(), b.motionDurationShort2, 87);
        hVar.f7817y = sd.i.D(getContext(), b.motionEasingLinearInterpolator, l9.a.f7925a);
        return hVar;
    }

    public final boolean g() {
        return this.f2965b0 && !TextUtils.isEmpty(this.f2966c0) && (this.f2968e0 instanceof pa.h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f2992z;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public i getBoxBackground() {
        int i = this.f2977n0;
        if (i == 1 || i == 2) {
            return this.f2968e0;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f2982t0;
    }

    public int getBoxBackgroundMode() {
        return this.f2977n0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.o0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2987w0;
        return layoutDirection == 1 ? this.f2974k0.f7356h.a(rectF) : this.f2974k0.f7355g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2987w0;
        return layoutDirection == 1 ? this.f2974k0.f7355g.a(rectF) : this.f2974k0.f7356h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2987w0;
        return layoutDirection == 1 ? this.f2974k0.f7354e.a(rectF) : this.f2974k0.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2987w0;
        return layoutDirection == 1 ? this.f2974k0.f.a(rectF) : this.f2974k0.f7354e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.I0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.J0;
    }

    public int getBoxStrokeWidth() {
        return this.f2979q0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2980r0;
    }

    public int getCounterMaxLength() {
        return this.H;
    }

    public CharSequence getCounterOverflowDescription() {
        a1 a1Var;
        if (this.G && this.I && (a1Var = this.K) != null) {
            return a1Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.V;
    }

    public ColorStateList getCounterTextColor() {
        return this.U;
    }

    public ColorStateList getCursorColor() {
        return this.W;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f2964a0;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.E0;
    }

    public EditText getEditText() {
        return this.f2992z;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f2988x.B.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f2988x.B.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f2988x.H;
    }

    public int getEndIconMode() {
        return this.f2988x.D;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f2988x.I;
    }

    public CheckableImageButton getEndIconView() {
        return this.f2988x.B;
    }

    public CharSequence getError() {
        t tVar = this.F;
        if (tVar.f10118q) {
            return tVar.f10117p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.F.f10121t;
    }

    public CharSequence getErrorContentDescription() {
        return this.F.f10120s;
    }

    public int getErrorCurrentTextColors() {
        a1 a1Var = this.F.f10119r;
        if (a1Var != null) {
            return a1Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f2988x.f10091x.getDrawable();
    }

    public CharSequence getHelperText() {
        t tVar = this.F;
        if (tVar.f10125x) {
            return tVar.f10124w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        a1 a1Var = this.F.f10126y;
        if (a1Var != null) {
            return a1Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.f2965b0) {
            return this.f2966c0;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.R0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        c cVar = this.R0;
        return cVar.g(cVar.f3591k);
    }

    public int getHintMaxLines() {
        return this.R0.f3582e0;
    }

    public ColorStateList getHintTextColor() {
        return this.F0;
    }

    public a0 getLengthCounter() {
        return this.J;
    }

    public int getMaxEms() {
        return this.C;
    }

    public int getMaxWidth() {
        return this.E;
    }

    public int getMinEms() {
        return this.B;
    }

    public int getMinWidth() {
        return this.D;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f2988x.B.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f2988x.B.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.O) {
            return this.N;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.R;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.Q;
    }

    public CharSequence getPrefixText() {
        return this.f2986w.f10136x;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f2986w.f10135w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f2986w.f10135w;
    }

    public m getShapeAppearanceModel() {
        return this.f2974k0;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f2986w.f10137y.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f2986w.f10137y.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f2986w.B;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f2986w.C;
    }

    public CharSequence getSuffixText() {
        return this.f2988x.K;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f2988x.L.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f2988x.L;
    }

    public Typeface getTypeface() {
        return this.f2989x0;
    }

    public final i h(boolean z10) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(d.mtrl_shape_corner_size_small_component);
        float f = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f2992z;
        float popupElevation = editText instanceof v ? ((v) editText).getPopupElevation() : getResources().getDimensionPixelOffset(d.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ka.k kVar = new ka.k();
        ka.k kVar2 = new ka.k();
        ka.k kVar3 = new ka.k();
        ka.k kVar4 = new ka.k();
        int i = 0;
        ka.f fVar = new ka.f(i);
        ka.f fVar2 = new ka.f(i);
        ka.f fVar3 = new ka.f(i);
        ka.f fVar4 = new ka.f(i);
        ka.a aVar = new ka.a(f);
        ka.a aVar2 = new ka.a(f);
        ka.a aVar3 = new ka.a(dimensionPixelOffset);
        ka.a aVar4 = new ka.a(dimensionPixelOffset);
        m mVar = new m();
        mVar.f7350a = kVar;
        mVar.f7351b = kVar2;
        mVar.f7352c = kVar3;
        mVar.f7353d = kVar4;
        mVar.f7354e = aVar;
        mVar.f = aVar2;
        mVar.f7355g = aVar4;
        mVar.f7356h = aVar3;
        mVar.i = fVar;
        mVar.f7357j = fVar2;
        mVar.f7358k = fVar3;
        mVar.f7359l = fVar4;
        EditText editText2 = this.f2992z;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof v ? ((v) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = i.f7331a0;
            TypedValue typedValueI = android.support.v4.media.session.b.I(b.colorSurface, context, i.class.getSimpleName());
            int i10 = typedValueI.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i10 != 0 ? context.getColor(i10) : typedValueI.data);
        }
        i iVar = new i();
        iVar.m(context);
        iVar.q(dropDownBackgroundTintList);
        iVar.p(popupElevation);
        iVar.setShapeAppearanceModel(mVar);
        g gVar = iVar.f7334w;
        if (gVar.f7322h == null) {
            gVar.f7322h = new Rect();
        }
        iVar.f7334w.f7322h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        iVar.invalidateSelf();
        return iVar;
    }

    public final int i(int i, boolean z10) {
        return ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f2992z.getCompoundPaddingLeft() : this.f2988x.c() : this.f2986w.a()) + i;
    }

    public final int j(int i, boolean z10) {
        return i - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f2992z.getCompoundPaddingRight() : this.f2986w.a() : this.f2988x.c());
    }

    public final void k() {
        int i = this.f2977n0;
        if (i == 0) {
            this.f2968e0 = null;
            this.f2972i0 = null;
            this.f2973j0 = null;
        } else if (i == 1) {
            this.f2968e0 = new i(this.f2974k0);
            this.f2972i0 = new i();
            this.f2973j0 = new i();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(q4.a.o(new StringBuilder(), this.f2977n0, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.f2965b0 || (this.f2968e0 instanceof pa.h)) {
                this.f2968e0 = new i(this.f2974k0);
            } else {
                m mVar = this.f2974k0;
                int i10 = pa.h.f10066d0;
                if (mVar == null) {
                    mVar = new m();
                }
                pa.g gVar = new pa.g(mVar, new RectF());
                pa.h hVar = new pa.h(gVar);
                hVar.f10067c0 = gVar;
                this.f2968e0 = hVar;
            }
            this.f2972i0 = null;
            this.f2973j0 = null;
        }
        u();
        z();
        if (this.f2977n0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.o0 = getResources().getDimensionPixelSize(d.material_font_2_0_box_collapsed_padding_top);
            } else if (com.bumptech.glide.c.z(getContext())) {
                this.o0 = getResources().getDimensionPixelSize(d.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.f2977n0 != 0) {
            v();
        }
        EditText editText = this.f2992z;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i11 = this.f2977n0;
                if (i11 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i11 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public final void n(a1 a1Var, int i) {
        try {
            a1Var.setTextAppearance(i);
            if (a1Var.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        a1Var.setTextAppearance(g.i.TextAppearance_AppCompat_Caption);
        a1Var.setTextColor(getContext().getColor(k9.c.design_error));
    }

    public final boolean o() {
        t tVar = this.F;
        return (tVar.f10116o != 1 || tVar.f10119r == null || TextUtils.isEmpty(tVar.f10117p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.R0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        p pVar = this.f2988x;
        pVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z10 = false;
        this.X0 = false;
        if (this.f2992z != null && this.f2992z.getMeasuredHeight() < (iMax = Math.max(pVar.getMeasuredHeight(), this.f2986w.getMeasuredHeight()))) {
            this.f2992z.setMinimumHeight(iMax);
            z10 = true;
        }
        boolean zS = s();
        if (z10 || zS) {
            this.f2992z.post(new pa.c(2, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        float fDescent;
        int i13;
        int compoundPaddingTop;
        super.onLayout(z10, i, i10, i11, i12);
        EditText editText = this.f2992z;
        if (editText != null) {
            Rect rect = this.f2983u0;
            da.d.a(this, editText, rect);
            i iVar = this.f2972i0;
            if (iVar != null) {
                int i14 = rect.bottom;
                iVar.setBounds(rect.left, i14 - this.f2979q0, rect.right, i14);
            }
            i iVar2 = this.f2973j0;
            if (iVar2 != null) {
                int i15 = rect.bottom;
                iVar2.setBounds(rect.left, i15 - this.f2980r0, rect.right, i15);
            }
            if (this.f2965b0) {
                float textSize = this.f2992z.getTextSize();
                c cVar = this.R0;
                float f = cVar.f3586h;
                TextPaint textPaint = cVar.P;
                if (f != textSize) {
                    cVar.f3586h = textSize;
                    cVar.j(false);
                }
                int gravity = this.f2992z.getGravity();
                int i16 = (gravity & (-113)) | 48;
                if (cVar.f3584g != i16) {
                    cVar.f3584g = i16;
                    cVar.j(false);
                }
                if (cVar.f != gravity) {
                    cVar.f = gravity;
                    cVar.j(false);
                }
                Rect rectD = d(rect);
                int i17 = rectD.left;
                int i18 = rectD.top;
                int i19 = rectD.right;
                int i20 = rectD.bottom;
                Rect rect2 = cVar.f3579d;
                if (rect2.left != i17 || rect2.top != i18 || rect2.right != i19 || rect2.bottom != i20) {
                    rect2.set(i17, i18, i19, i20);
                    cVar.N = true;
                }
                if (this.f2992z == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(cVar.f3586h);
                    textPaint.setTypeface(cVar.f3603v);
                    textPaint.setLetterSpacing(cVar.X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(cVar.f3586h);
                    textPaint.setTypeface(cVar.f3603v);
                    textPaint.setLetterSpacing(cVar.X);
                    fDescent = cVar.f3593l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f2992z.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f2985v0;
                rect3.left = compoundPaddingLeft;
                if (this.f2977n0 != 1 || this.f2992z.getMinLines() > 1) {
                    if (this.f2977n0 != 0 || getHintMaxLines() == 1) {
                        i13 = 0;
                    } else {
                        textPaint.setTextSize(cVar.f3586h);
                        textPaint.setTypeface(cVar.f3603v);
                        textPaint.setLetterSpacing(cVar.X);
                        i13 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f2992z.getCompoundPaddingTop() + rect.top) - i13;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f2992z.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f2977n0 != 1 || this.f2992z.getMinLines() > 1) ? rect.bottom - this.f2992z.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i21 = rect3.left;
                int i22 = rect3.top;
                int i23 = rect3.right;
                Rect rect4 = cVar.f3577c;
                if (rect4.left != i21 || rect4.top != i22 || rect4.right != i23 || rect4.bottom != compoundPaddingBottom || true != cVar.f3592k0) {
                    rect4.set(i21, i22, i23, compoundPaddingBottom);
                    cVar.N = true;
                    cVar.f3592k0 = true;
                }
                cVar.j(false);
                if (!g() || this.Q0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        float f;
        EditText editText;
        super.onMeasure(i, i10);
        boolean z10 = this.X0;
        p pVar = this.f2988x;
        if (!z10) {
            pVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.X0 = true;
        }
        if (this.P != null && (editText = this.f2992z) != null) {
            this.P.setGravity(editText.getGravity());
            this.P.setPadding(this.f2992z.getCompoundPaddingLeft(), this.f2992z.getCompoundPaddingTop(), this.f2992z.getCompoundPaddingRight(), this.f2992z.getCompoundPaddingBottom());
        }
        pVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f2992z.getMeasuredWidth() - this.f2992z.getCompoundPaddingLeft()) - this.f2992z.getCompoundPaddingRight();
        c cVar = this.R0;
        TextPaint textPaint = cVar.P;
        textPaint.setTextSize(cVar.i);
        textPaint.setTypeface(cVar.f3600s);
        textPaint.setLetterSpacing(cVar.W);
        float f10 = measuredWidth;
        cVar.f3588i0 = cVar.e(cVar.f3583f0, textPaint, cVar.B, (cVar.i / cVar.f3586h) * f10, cVar.D).getHeight();
        textPaint.setTextSize(cVar.f3586h);
        textPaint.setTypeface(cVar.f3603v);
        textPaint.setLetterSpacing(cVar.X);
        cVar.f3590j0 = cVar.e(cVar.f3582e0, textPaint, cVar.B, f10, cVar.D).getHeight();
        EditText editText2 = this.f2992z;
        Rect rect = this.f2983u0;
        da.d.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i11 = rectD.left;
        int i12 = rectD.top;
        int i13 = rectD.right;
        int i14 = rectD.bottom;
        Rect rect2 = cVar.f3579d;
        if (rect2.left != i11 || rect2.top != i12 || rect2.right != i13 || rect2.bottom != i14) {
            rect2.set(i11, i12, i13, i14);
            cVar.N = true;
        }
        v();
        a();
        if (this.f2992z == null) {
            return;
        }
        int i15 = cVar.f3590j0;
        if (i15 != -1) {
            f = i15;
        } else {
            TextPaint textPaint2 = cVar.P;
            textPaint2.setTextSize(cVar.f3586h);
            textPaint2.setTypeface(cVar.f3603v);
            textPaint2.setLetterSpacing(cVar.X);
            f = -textPaint2.ascent();
        }
        if (this.N != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.P.getPaint());
            textPaint3.setTextSize(this.P.getTextSize());
            textPaint3.setTypeface(this.P.getTypeface());
            textPaint3.setLetterSpacing(this.P.getLetterSpacing());
            da.y yVar = new da.y(this.N, textPaint3, measuredWidth);
            yVar.f3647k = getLayoutDirection() == 1;
            yVar.f3646j = true;
            float lineSpacingExtra = this.P.getLineSpacingExtra();
            float lineSpacingMultiplier = this.P.getLineSpacingMultiplier();
            yVar.f3644g = lineSpacingExtra;
            yVar.f3645h = lineSpacingMultiplier;
            yVar.f3649m = new kb.d(8, this);
            f = (this.f2977n0 == 1 ? cVar.f() + this.o0 + this.f2990y : 0.0f) + yVar.a().getHeight();
        }
        float fMax = Math.max(f, f);
        if (this.f2992z.getMeasuredHeight() < fMax) {
            this.f2992z.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b0 b0Var = (b0) parcelable;
        super.onRestoreInstanceState(b0Var.f112v);
        setError(b0Var.f10051x);
        if (b0Var.f10052y) {
            post(new androidx.fragment.app.m(25, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z10 = i == 1;
        if (z10 != this.f2975l0) {
            ka.d dVar = this.f2974k0.f7354e;
            RectF rectF = this.f2987w0;
            float fA = dVar.a(rectF);
            float fA2 = this.f2974k0.f.a(rectF);
            float fA3 = this.f2974k0.f7356h.a(rectF);
            float fA4 = this.f2974k0.f7355g.a(rectF);
            m mVar = this.f2974k0;
            com.bumptech.glide.d dVar2 = mVar.f7350a;
            com.bumptech.glide.d dVar3 = mVar.f7351b;
            com.bumptech.glide.d dVar4 = mVar.f7353d;
            com.bumptech.glide.d dVar5 = mVar.f7352c;
            ka.f fVar = new ka.f(0);
            ka.f fVar2 = new ka.f(0);
            ka.f fVar3 = new ka.f(0);
            ka.f fVar4 = new ka.f(0);
            ka.a aVar = new ka.a(fA2);
            ka.a aVar2 = new ka.a(fA);
            ka.a aVar3 = new ka.a(fA4);
            ka.a aVar4 = new ka.a(fA3);
            m mVar2 = new m();
            mVar2.f7350a = dVar3;
            mVar2.f7351b = dVar2;
            mVar2.f7352c = dVar4;
            mVar2.f7353d = dVar5;
            mVar2.f7354e = aVar;
            mVar2.f = aVar2;
            mVar2.f7355g = aVar4;
            mVar2.f7356h = aVar3;
            mVar2.i = fVar;
            mVar2.f7357j = fVar2;
            mVar2.f7358k = fVar3;
            mVar2.f7359l = fVar4;
            this.f2975l0 = z10;
            setShapeAppearanceModel(mVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b0 b0Var = new b0(super.onSaveInstanceState());
        if (o()) {
            b0Var.f10051x = getError();
        }
        p pVar = this.f2988x;
        b0Var.f10052y = pVar.D != 0 && pVar.B.f2921y;
        return b0Var;
    }

    public final void p(Editable editable) {
        ((l) this.J).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z10 = this.I;
        int i = this.H;
        if (i == -1) {
            this.K.setText(String.valueOf(length));
            this.K.setContentDescription(null);
            this.I = false;
        } else {
            this.I = length > i;
            Context context = getContext();
            this.K.setContentDescription(context.getString(this.I ? j.character_counter_overflowed_content_description : j.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.H)));
            if (z10 != this.I) {
                q();
            }
            String str = r0.b.f10833b;
            r0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? r0.b.f10836e : r0.b.f10835d;
            a1 a1Var = this.K;
            String string = getContext().getString(j.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.H));
            bVar.getClass();
            o4 o4Var = r0.f.f10843a;
            a1Var.setText(string != null ? bVar.c(string).toString() : null);
        }
        if (this.f2992z == null || z10 == this.I) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        a1 a1Var = this.K;
        if (a1Var != null) {
            n(a1Var, this.I ? this.L : this.M);
            if (!this.I && (colorStateList2 = this.U) != null) {
                this.K.setTextColor(colorStateList2);
            }
            if (!this.I || (colorStateList = this.V) == null) {
                return;
            }
            this.K.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.W
            if (r0 == 0) goto L5
            goto L25
        L5:
            android.content.Context r0 = r4.getContext()
            int r1 = g.a.colorControlActivated
            android.util.TypedValue r1 = android.support.v4.media.session.b.G(r0, r1)
            r2 = 0
            if (r1 != 0) goto L14
        L12:
            r0 = r2
            goto L25
        L14:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1d
            android.content.res.ColorStateList r0 = i0.c.c(r0, r3)
            goto L25
        L1d:
            int r0 = r1.data
            if (r0 == 0) goto L12
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L25:
            android.widget.EditText r1 = r4.f2992z
            if (r1 == 0) goto L50
            android.graphics.drawable.Drawable r1 = o.k1.d(r1)
            if (r1 != 0) goto L30
            goto L50
        L30:
            android.widget.EditText r1 = r4.f2992z
            android.graphics.drawable.Drawable r1 = o.k1.d(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L48
            o.a1 r2 = r4.K
            if (r2 == 0) goto L4d
            boolean r2 = r4.I
            if (r2 == 0) goto L4d
        L48:
            android.content.res.ColorStateList r2 = r4.f2964a0
            if (r2 == 0) goto L4d
            r0 = r2
        L4d:
            r1.setTintList(r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.r():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f2982t0 != i) {
            this.f2982t0 = i;
            this.K0 = i;
            this.M0 = i;
            this.N0 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.K0 = defaultColor;
        this.f2982t0 = defaultColor;
        this.L0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.M0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.N0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f2977n0) {
            return;
        }
        this.f2977n0 = i;
        if (this.f2992z != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.o0 = i;
    }

    public void setBoxCornerFamily(int i) {
        ka.l lVarG = this.f2974k0.g();
        ka.d dVar = this.f2974k0.f7354e;
        lVarG.f7339a = e.e(i);
        lVarG.f7343e = dVar;
        ka.d dVar2 = this.f2974k0.f;
        lVarG.f7340b = e.e(i);
        lVarG.f = dVar2;
        ka.d dVar3 = this.f2974k0.f7356h;
        lVarG.f7342d = e.e(i);
        lVarG.f7345h = dVar3;
        ka.d dVar4 = this.f2974k0.f7355g;
        lVarG.f7341c = e.e(i);
        lVarG.f7344g = dVar4;
        this.f2974k0 = lVarG.a();
        c();
    }

    public void setBoxStrokeColor(int i) {
        if (this.I0 != i) {
            this.I0 = i;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.G0 = colorStateList.getDefaultColor();
            this.O0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.H0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.I0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.I0 != colorStateList.getDefaultColor()) {
            this.I0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.J0 != colorStateList) {
            this.J0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f2979q0 = i;
        z();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f2980r0 = i;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.G != z10) {
            t tVar = this.F;
            if (z10) {
                a1 a1Var = new a1(getContext(), null);
                this.K = a1Var;
                a1Var.setId(k9.f.textinput_counter);
                Typeface typeface = this.f2989x0;
                if (typeface != null) {
                    this.K.setTypeface(typeface);
                }
                this.K.setMaxLines(1);
                tVar.a(this.K, 2);
                ((ViewGroup.MarginLayoutParams) this.K.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(d.mtrl_textinput_counter_margin_start));
                q();
                if (this.K != null) {
                    EditText editText = this.f2992z;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                tVar.g(this.K, 2);
                this.K = null;
            }
            this.G = z10;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.H != i) {
            if (i > 0) {
                this.H = i;
            } else {
                this.H = -1;
            }
            if (!this.G || this.K == null) {
                return;
            }
            EditText editText = this.f2992z;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.L != i) {
            this.L = i;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.M != i) {
            this.M = i;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f2964a0 != colorStateList) {
            this.f2964a0 = colorStateList;
            if (o() || (this.K != null && this.I)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.E0 = colorStateList;
        this.F0 = colorStateList;
        if (this.f2992z != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        m(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f2988x.B.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f2988x.B.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i) {
        p pVar = this.f2988x;
        CharSequence text = i != 0 ? pVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = pVar.B;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        p pVar = this.f2988x;
        Drawable drawableI = i != 0 ? j4.i(pVar.getContext(), i) : null;
        TextInputLayout textInputLayout = pVar.f10089v;
        CheckableImageButton checkableImageButton = pVar.B;
        checkableImageButton.setImageDrawable(drawableI);
        if (drawableI != null) {
            u8.a.b(textInputLayout, checkableImageButton, pVar.F, pVar.G);
            u8.a.y(textInputLayout, checkableImageButton, pVar.F);
        }
    }

    public void setEndIconMinSize(int i) {
        p pVar = this.f2988x;
        if (i < 0) {
            pVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != pVar.H) {
            pVar.H = i;
            CheckableImageButton checkableImageButton = pVar.B;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = pVar.f10091x;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.f2988x.g(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        p pVar = this.f2988x;
        CheckableImageButton checkableImageButton = pVar.B;
        View.OnLongClickListener onLongClickListener = pVar.J;
        checkableImageButton.setOnClickListener(onClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        p pVar = this.f2988x;
        pVar.J = onLongClickListener;
        CheckableImageButton checkableImageButton = pVar.B;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        p pVar = this.f2988x;
        pVar.I = scaleType;
        pVar.B.setScaleType(scaleType);
        pVar.f10091x.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        p pVar = this.f2988x;
        if (pVar.F != colorStateList) {
            pVar.F = colorStateList;
            u8.a.b(pVar.f10089v, pVar.B, colorStateList, pVar.G);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        p pVar = this.f2988x;
        if (pVar.G != mode) {
            pVar.G = mode;
            u8.a.b(pVar.f10089v, pVar.B, pVar.F, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        this.f2988x.h(z10);
    }

    public void setError(CharSequence charSequence) {
        t tVar = this.F;
        if (!tVar.f10118q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            tVar.f();
            return;
        }
        tVar.c();
        tVar.f10117p = charSequence;
        tVar.f10119r.setText(charSequence);
        int i = tVar.f10115n;
        if (i != 1) {
            tVar.f10116o = 1;
        }
        tVar.i(i, tVar.f10116o, tVar.h(tVar.f10119r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        t tVar = this.F;
        tVar.f10121t = i;
        a1 a1Var = tVar.f10119r;
        if (a1Var != null) {
            a1Var.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        t tVar = this.F;
        tVar.f10120s = charSequence;
        a1 a1Var = tVar.f10119r;
        if (a1Var != null) {
            a1Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        t tVar = this.F;
        TextInputLayout textInputLayout = tVar.f10110h;
        if (tVar.f10118q == z10) {
            return;
        }
        tVar.c();
        if (z10) {
            a1 a1Var = new a1(tVar.f10109g, null);
            tVar.f10119r = a1Var;
            a1Var.setId(k9.f.textinput_error);
            tVar.f10119r.setTextAlignment(5);
            Typeface typeface = tVar.B;
            if (typeface != null) {
                tVar.f10119r.setTypeface(typeface);
            }
            int i = tVar.f10122u;
            tVar.f10122u = i;
            a1 a1Var2 = tVar.f10119r;
            if (a1Var2 != null) {
                tVar.f10110h.n(a1Var2, i);
            }
            ColorStateList colorStateList = tVar.f10123v;
            tVar.f10123v = colorStateList;
            a1 a1Var3 = tVar.f10119r;
            if (a1Var3 != null && colorStateList != null) {
                a1Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = tVar.f10120s;
            tVar.f10120s = charSequence;
            a1 a1Var4 = tVar.f10119r;
            if (a1Var4 != null) {
                a1Var4.setContentDescription(charSequence);
            }
            int i10 = tVar.f10121t;
            tVar.f10121t = i10;
            a1 a1Var5 = tVar.f10119r;
            if (a1Var5 != null) {
                a1Var5.setAccessibilityLiveRegion(i10);
            }
            tVar.f10119r.setVisibility(4);
            tVar.a(tVar.f10119r, 0);
        } else {
            tVar.f();
            tVar.g(tVar.f10119r, 0);
            tVar.f10119r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        tVar.f10118q = z10;
    }

    public void setErrorIconDrawable(int i) {
        p pVar = this.f2988x;
        pVar.i(i != 0 ? j4.i(pVar.getContext(), i) : null);
        u8.a.y(pVar.f10089v, pVar.f10091x, pVar.f10092y);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        p pVar = this.f2988x;
        CheckableImageButton checkableImageButton = pVar.f10091x;
        View.OnLongClickListener onLongClickListener = pVar.A;
        checkableImageButton.setOnClickListener(onClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        p pVar = this.f2988x;
        pVar.A = onLongClickListener;
        CheckableImageButton checkableImageButton = pVar.f10091x;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        p pVar = this.f2988x;
        if (pVar.f10092y != colorStateList) {
            pVar.f10092y = colorStateList;
            u8.a.b(pVar.f10089v, pVar.f10091x, colorStateList, pVar.f10093z);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        p pVar = this.f2988x;
        if (pVar.f10093z != mode) {
            pVar.f10093z = mode;
            u8.a.b(pVar.f10089v, pVar.f10091x, pVar.f10092y, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        t tVar = this.F;
        tVar.f10122u = i;
        a1 a1Var = tVar.f10119r;
        if (a1Var != null) {
            tVar.f10110h.n(a1Var, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        t tVar = this.F;
        tVar.f10123v = colorStateList;
        a1 a1Var = tVar.f10119r;
        if (a1Var == null || colorStateList == null) {
            return;
        }
        a1Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.S0 != z10) {
            this.S0 = z10;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        t tVar = this.F;
        if (zIsEmpty) {
            if (tVar.f10125x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!tVar.f10125x) {
            setHelperTextEnabled(true);
        }
        tVar.c();
        tVar.f10124w = charSequence;
        tVar.f10126y.setText(charSequence);
        int i = tVar.f10115n;
        if (i != 2) {
            tVar.f10116o = 2;
        }
        tVar.i(i, tVar.f10116o, tVar.h(tVar.f10126y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        t tVar = this.F;
        tVar.A = colorStateList;
        a1 a1Var = tVar.f10126y;
        if (a1Var == null || colorStateList == null) {
            return;
        }
        a1Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        t tVar = this.F;
        TextInputLayout textInputLayout = tVar.f10110h;
        if (tVar.f10125x == z10) {
            return;
        }
        tVar.c();
        if (z10) {
            a1 a1Var = new a1(tVar.f10109g, null);
            tVar.f10126y = a1Var;
            a1Var.setId(k9.f.textinput_helper_text);
            tVar.f10126y.setTextAlignment(5);
            Typeface typeface = tVar.B;
            if (typeface != null) {
                tVar.f10126y.setTypeface(typeface);
            }
            tVar.f10126y.setVisibility(4);
            tVar.f10126y.setAccessibilityLiveRegion(1);
            int i = tVar.f10127z;
            tVar.f10127z = i;
            a1 a1Var2 = tVar.f10126y;
            if (a1Var2 != null) {
                a1Var2.setTextAppearance(i);
            }
            ColorStateList colorStateList = tVar.A;
            tVar.A = colorStateList;
            a1 a1Var3 = tVar.f10126y;
            if (a1Var3 != null && colorStateList != null) {
                a1Var3.setTextColor(colorStateList);
            }
            tVar.a(tVar.f10126y, 1);
            tVar.f10126y.setAccessibilityDelegate(new s(tVar));
        } else {
            tVar.c();
            int i10 = tVar.f10115n;
            if (i10 == 2) {
                tVar.f10116o = 0;
            }
            tVar.i(i10, tVar.f10116o, tVar.h(tVar.f10126y, ""));
            tVar.g(tVar.f10126y, 1);
            tVar.f10126y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        tVar.f10125x = z10;
    }

    public void setHelperTextTextAppearance(int i) {
        t tVar = this.F;
        tVar.f10127z = i;
        a1 a1Var = tVar.f10126y;
        if (a1Var != null) {
            a1Var.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f2965b0) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.T0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f2965b0) {
            this.f2965b0 = z10;
            if (z10) {
                CharSequence hint = this.f2992z.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f2966c0)) {
                        setHint(hint);
                    }
                    this.f2992z.setHint((CharSequence) null);
                }
                this.f2967d0 = true;
            } else {
                this.f2967d0 = false;
                if (!TextUtils.isEmpty(this.f2966c0) && TextUtils.isEmpty(this.f2992z.getHint())) {
                    this.f2992z.setHint(this.f2966c0);
                }
                setHintInternal(null);
            }
            if (this.f2992z != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i) {
        c cVar = this.R0;
        if (i != cVar.f3583f0) {
            cVar.f3583f0 = i;
            cVar.j(false);
        }
        if (i != cVar.f3582e0) {
            cVar.f3582e0 = i;
            cVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        c cVar = this.R0;
        TextInputLayout textInputLayout = cVar.f3573a;
        ha.d dVar = new ha.d(textInputLayout.getContext(), i);
        ColorStateList colorStateList = dVar.f5864k;
        if (colorStateList != null) {
            cVar.f3591k = colorStateList;
        }
        float f = dVar.f5865l;
        if (f != 0.0f) {
            cVar.i = f;
        }
        ColorStateList colorStateList2 = dVar.f5856a;
        if (colorStateList2 != null) {
            cVar.V = colorStateList2;
        }
        cVar.T = dVar.f;
        cVar.U = dVar.f5861g;
        cVar.S = dVar.f5862h;
        cVar.W = dVar.f5863j;
        ha.a aVar = cVar.f3607z;
        if (aVar != null) {
            aVar.f5850c = true;
        }
        p6.c cVar2 = new p6.c(8, cVar);
        dVar.a();
        cVar.f3607z = new ha.a(cVar2, dVar.f5869p);
        dVar.b(textInputLayout.getContext(), cVar.f3607z);
        cVar.j(false);
        this.F0 = cVar.f3591k;
        if (this.f2992z != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            if (this.E0 == null) {
                c cVar = this.R0;
                if (cVar.f3591k != colorStateList) {
                    cVar.f3591k = colorStateList;
                    cVar.j(false);
                }
            }
            this.F0 = colorStateList;
            if (this.f2992z != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(a0 a0Var) {
        this.J = a0Var;
    }

    public void setMaxEms(int i) {
        this.C = i;
        EditText editText = this.f2992z;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.E = i;
        EditText editText = this.f2992z;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.B = i;
        EditText editText = this.f2992z;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.D = i;
        EditText editText = this.f2992z;
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
        p pVar = this.f2988x;
        pVar.B.setContentDescription(i != 0 ? pVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        p pVar = this.f2988x;
        pVar.B.setImageDrawable(i != 0 ? j4.i(pVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        p pVar = this.f2988x;
        if (z10 && pVar.D != 1) {
            pVar.g(1);
        } else if (z10) {
            pVar.getClass();
        } else {
            pVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        p pVar = this.f2988x;
        pVar.F = colorStateList;
        u8.a.b(pVar.f10089v, pVar.B, colorStateList, pVar.G);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        p pVar = this.f2988x;
        pVar.G = mode;
        u8.a.b(pVar.f10089v, pVar.B, pVar.F, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.P == null) {
            a1 a1Var = new a1(getContext(), null);
            this.P = a1Var;
            a1Var.setId(k9.f.textinput_placeholder);
            this.P.setImportantForAccessibility(1);
            this.P.setAccessibilityLiveRegion(1);
            h hVarF = f();
            this.S = hVarF;
            hVarF.f7815w = 67L;
            this.T = f();
            setPlaceholderTextAppearance(this.R);
            setPlaceholderTextColor(this.Q);
            m0.n(this.P, new com.google.android.material.datepicker.g(4));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.O) {
                setPlaceholderTextEnabled(true);
            }
            this.N = charSequence;
        }
        EditText editText = this.f2992z;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.R = i;
        a1 a1Var = this.P;
        if (a1Var != null) {
            a1Var.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            a1 a1Var = this.P;
            if (a1Var == null || colorStateList == null) {
                return;
            }
            a1Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        x xVar = this.f2986w;
        xVar.getClass();
        xVar.f10136x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        xVar.f10135w.setText(charSequence);
        xVar.e();
    }

    public void setPrefixTextAppearance(int i) {
        this.f2986w.f10135w.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f2986w.f10135w.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(m mVar) {
        i iVar = this.f2968e0;
        if (iVar == null || iVar.f7334w.f7316a == mVar) {
            return;
        }
        this.f2974k0 = mVar;
        c();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f2986w.f10137y.setCheckable(z10);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? j4.i(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        x xVar = this.f2986w;
        if (i < 0) {
            xVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != xVar.B) {
            xVar.B = i;
            CheckableImageButton checkableImageButton = xVar.f10137y;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        x xVar = this.f2986w;
        CheckableImageButton checkableImageButton = xVar.f10137y;
        View.OnLongClickListener onLongClickListener = xVar.D;
        checkableImageButton.setOnClickListener(onClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        x xVar = this.f2986w;
        xVar.D = onLongClickListener;
        CheckableImageButton checkableImageButton = xVar.f10137y;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        u8.a.B(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        x xVar = this.f2986w;
        xVar.C = scaleType;
        xVar.f10137y.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        x xVar = this.f2986w;
        if (xVar.f10138z != colorStateList) {
            xVar.f10138z = colorStateList;
            u8.a.b(xVar.f10134v, xVar.f10137y, colorStateList, xVar.A);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        x xVar = this.f2986w;
        if (xVar.A != mode) {
            xVar.A = mode;
            u8.a.b(xVar.f10134v, xVar.f10137y, xVar.f10138z, mode);
        }
    }

    public void setStartIconVisible(boolean z10) {
        this.f2986w.c(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        p pVar = this.f2988x;
        pVar.getClass();
        pVar.K = TextUtils.isEmpty(charSequence) ? null : charSequence;
        pVar.L.setText(charSequence);
        pVar.n();
    }

    public void setSuffixTextAppearance(int i) {
        this.f2988x.L.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f2988x.L.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(z zVar) {
        EditText editText = this.f2992z;
        if (editText != null) {
            m0.n(editText, zVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2989x0) {
            this.f2989x0 = typeface;
            this.R0.n(typeface);
            t tVar = this.F;
            if (typeface != tVar.B) {
                tVar.B = typeface;
                a1 a1Var = tVar.f10119r;
                if (a1Var != null) {
                    a1Var.setTypeface(typeface);
                }
                a1 a1Var2 = tVar.f10126y;
                if (a1Var2 != null) {
                    a1Var2.setTypeface(typeface);
                }
            }
            a1 a1Var3 = this.K;
            if (a1Var3 != null) {
                a1Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        a1 a1Var;
        EditText editText = this.f2992z;
        if (editText == null || this.f2977n0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = n1.f9275a;
        Drawable drawableMutate = background.mutate();
        if (o()) {
            drawableMutate.setColorFilter(r.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.I && (a1Var = this.K) != null) {
            drawableMutate.setColorFilter(r.c(a1Var.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.f2992z.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.f2992z;
        if (editText == null || this.f2968e0 == null) {
            return;
        }
        if ((this.f2971h0 || editText.getBackground() == null) && this.f2977n0 != 0) {
            this.f2992z.setBackground(getEditTextBoxBackground());
            this.f2971h0 = true;
        }
    }

    public final void v() {
        if (this.f2977n0 != 1) {
            FrameLayout frameLayout = this.f2984v;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        a1 a1Var;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f2992z;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2992z;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.E0;
        c cVar = this.R0;
        if (colorStateList2 != null) {
            cVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.E0;
            cVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.O0) : this.O0));
        } else if (o()) {
            a1 a1Var2 = this.F.f10119r;
            cVar.k(a1Var2 != null ? a1Var2.getTextColors() : null);
        } else if (this.I && (a1Var = this.K) != null) {
            cVar.k(a1Var.getTextColors());
        } else if (z13 && (colorStateList = this.F0) != null && cVar.f3591k != colorStateList) {
            cVar.f3591k = colorStateList;
            cVar.j(false);
        }
        p pVar = this.f2988x;
        x xVar = this.f2986w;
        if (z12 || !this.S0 || (isEnabled() && z13)) {
            if (z11 || this.Q0) {
                ValueAnimator valueAnimator = this.U0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.U0.cancel();
                }
                if (z10 && this.T0) {
                    b(1.0f);
                } else {
                    cVar.m(1.0f);
                }
                this.Q0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.f2992z;
                x(editText3 != null ? editText3.getText() : null);
                xVar.E = false;
                xVar.e();
                pVar.M = false;
                pVar.n();
                return;
            }
            return;
        }
        if (z11 || !this.Q0) {
            ValueAnimator valueAnimator2 = this.U0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.U0.cancel();
            }
            if (z10 && this.T0) {
                b(0.0f);
            } else {
                cVar.m(0.0f);
            }
            if (g() && !((pa.h) this.f2968e0).f10067c0.f10065r.isEmpty() && g()) {
                ((pa.h) this.f2968e0).y(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.Q0 = true;
            a1 a1Var3 = this.P;
            if (a1Var3 != null && this.O) {
                a1Var3.setText((CharSequence) null);
                l5.r.a(this.f2984v, this.T);
                this.P.setVisibility(4);
            }
            xVar.E = true;
            xVar.e();
            pVar.M = true;
            pVar.n();
        }
    }

    public final void x(Editable editable) {
        ((l) this.J).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f2984v;
        if (length != 0 || this.Q0) {
            a1 a1Var = this.P;
            if (a1Var == null || !this.O) {
                return;
            }
            a1Var.setText((CharSequence) null);
            l5.r.a(frameLayout, this.T);
            this.P.setVisibility(4);
            return;
        }
        if (this.P == null || !this.O || TextUtils.isEmpty(this.N)) {
            return;
        }
        this.P.setText(this.N);
        l5.r.a(frameLayout, this.S);
        this.P.setVisibility(0);
        this.P.bringToFront();
    }

    public final void y(boolean z10, boolean z11) {
        int defaultColor = this.J0.getDefaultColor();
        int colorForState = this.J0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.J0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.f2981s0 = colorForState2;
        } else if (z11) {
            this.f2981s0 = colorForState;
        } else {
            this.f2981s0 = defaultColor;
        }
    }

    public final void z() {
        a1 a1Var;
        EditText editText;
        EditText editText2;
        if (this.f2968e0 == null || this.f2977n0 == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f2992z) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f2992z) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.f2981s0 = this.O0;
        } else if (o()) {
            if (this.J0 != null) {
                y(z11, z10);
            } else {
                this.f2981s0 = getErrorCurrentTextColors();
            }
        } else if (!this.I || (a1Var = this.K) == null) {
            if (z11) {
                this.f2981s0 = this.I0;
            } else if (z10) {
                this.f2981s0 = this.H0;
            } else {
                this.f2981s0 = this.G0;
            }
        } else if (this.J0 != null) {
            y(z11, z10);
        } else {
            this.f2981s0 = a1Var.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        p pVar = this.f2988x;
        TextInputLayout textInputLayout = pVar.f10089v;
        CheckableImageButton checkableImageButton = pVar.B;
        TextInputLayout textInputLayout2 = pVar.f10089v;
        pVar.l();
        u8.a.y(textInputLayout2, pVar.f10091x, pVar.f10092y);
        u8.a.y(textInputLayout2, checkableImageButton, pVar.F);
        if (pVar.b() instanceof pa.l) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                u8.a.b(textInputLayout, checkableImageButton, pVar.F, pVar.G);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        x xVar = this.f2986w;
        u8.a.y(xVar.f10134v, xVar.f10137y, xVar.f10138z);
        if (this.f2977n0 == 2) {
            int i = this.f2978p0;
            if (z11 && isEnabled()) {
                this.f2978p0 = this.f2980r0;
            } else {
                this.f2978p0 = this.f2979q0;
            }
            if (this.f2978p0 != i && g() && !this.Q0) {
                if (g()) {
                    ((pa.h) this.f2968e0).y(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.f2977n0 == 1) {
            if (!isEnabled()) {
                this.f2982t0 = this.L0;
            } else if (z10 && !z11) {
                this.f2982t0 = this.N0;
            } else if (z11) {
                this.f2982t0 = this.M0;
            } else {
                this.f2982t0 = this.K0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2986w.f10137y;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f2986w.b(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f2988x.B.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f2988x.B.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f2988x.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2988x.B;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        p pVar = this.f2988x;
        TextInputLayout textInputLayout = pVar.f10089v;
        CheckableImageButton checkableImageButton = pVar.B;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            u8.a.b(textInputLayout, checkableImageButton, pVar.F, pVar.G);
            u8.a.y(textInputLayout, checkableImageButton, pVar.F);
        }
    }
}
