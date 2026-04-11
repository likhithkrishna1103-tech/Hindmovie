package pa;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.y0;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import da.e0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends LinearLayout {
    public View.OnLongClickListener A;
    public final CheckableImageButton B;
    public final o C;
    public int D;
    public final LinkedHashSet E;
    public ColorStateList F;
    public PorterDuff.Mode G;
    public int H;
    public ImageView.ScaleType I;
    public View.OnLongClickListener J;
    public CharSequence K;
    public final a1 L;
    public boolean M;
    public EditText N;
    public final AccessibilityManager O;
    public AccessibilityManager.TouchExplorationStateChangeListener P;
    public final m Q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextInputLayout f10089v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrameLayout f10090w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CheckableImageButton f10091x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f10092y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PorterDuff.Mode f10093z;

    public p(TextInputLayout textInputLayout, l7.a aVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.D = 0;
        this.E = new LinkedHashSet();
        this.Q = new m(this);
        n nVar = new n(this);
        this.O = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f10089v = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f10090w = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, k9.f.text_input_error_icon);
        this.f10091x = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, k9.f.text_input_end_icon);
        this.B = checkableImageButtonA2;
        o oVar = new o();
        oVar.f10087c = new SparseArray();
        oVar.f10088d = this;
        int i = k9.l.TextInputLayout_endIconDrawable;
        TypedArray typedArray = (TypedArray) aVar.f7867x;
        oVar.f10085a = typedArray.getResourceId(i, 0);
        oVar.f10086b = typedArray.getResourceId(k9.l.TextInputLayout_passwordToggleDrawable, 0);
        this.C = oVar;
        a1 a1Var = new a1(getContext(), null);
        this.L = a1Var;
        int i10 = k9.l.TextInputLayout_errorIconTint;
        TypedArray typedArray2 = (TypedArray) aVar.f7867x;
        if (typedArray2.hasValue(i10)) {
            this.f10092y = com.bumptech.glide.c.j(getContext(), aVar, k9.l.TextInputLayout_errorIconTint);
        }
        if (typedArray2.hasValue(k9.l.TextInputLayout_errorIconTintMode)) {
            this.f10093z = e0.c(typedArray2.getInt(k9.l.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (typedArray2.hasValue(k9.l.TextInputLayout_errorIconDrawable)) {
            i(aVar.u(k9.l.TextInputLayout_errorIconDrawable));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(k9.j.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray2.hasValue(k9.l.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray2.hasValue(k9.l.TextInputLayout_endIconTint)) {
                this.F = com.bumptech.glide.c.j(getContext(), aVar, k9.l.TextInputLayout_endIconTint);
            }
            if (typedArray2.hasValue(k9.l.TextInputLayout_endIconTintMode)) {
                this.G = e0.c(typedArray2.getInt(k9.l.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (typedArray2.hasValue(k9.l.TextInputLayout_endIconMode)) {
            g(typedArray2.getInt(k9.l.TextInputLayout_endIconMode, 0));
            if (typedArray2.hasValue(k9.l.TextInputLayout_endIconContentDescription) && checkableImageButtonA2.getContentDescription() != (text = typedArray2.getText(k9.l.TextInputLayout_endIconContentDescription))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray2.getBoolean(k9.l.TextInputLayout_endIconCheckable, true));
        } else if (typedArray2.hasValue(k9.l.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray2.hasValue(k9.l.TextInputLayout_passwordToggleTint)) {
                this.F = com.bumptech.glide.c.j(getContext(), aVar, k9.l.TextInputLayout_passwordToggleTint);
            }
            if (typedArray2.hasValue(k9.l.TextInputLayout_passwordToggleTintMode)) {
                this.G = e0.c(typedArray2.getInt(k9.l.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            g(typedArray2.getBoolean(k9.l.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            CharSequence text2 = typedArray2.getText(k9.l.TextInputLayout_passwordToggleContentDescription);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(k9.l.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(k9.d.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.H) {
            this.H = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray2.hasValue(k9.l.TextInputLayout_endIconScaleType)) {
            ImageView.ScaleType scaleTypeK = u8.a.k(typedArray2.getInt(k9.l.TextInputLayout_endIconScaleType, -1));
            this.I = scaleTypeK;
            checkableImageButtonA2.setScaleType(scaleTypeK);
            checkableImageButtonA.setScaleType(scaleTypeK);
        }
        a1Var.setVisibility(8);
        a1Var.setId(k9.f.textinput_suffix_text);
        a1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        a1Var.setAccessibilityLiveRegion(1);
        a1Var.setTextAppearance(typedArray2.getResourceId(k9.l.TextInputLayout_suffixTextAppearance, 0));
        if (typedArray2.hasValue(k9.l.TextInputLayout_suffixTextColor)) {
            a1Var.setTextColor(aVar.r(k9.l.TextInputLayout_suffixTextColor));
        }
        CharSequence text3 = typedArray2.getText(k9.l.TextInputLayout_suffixText);
        this.K = TextUtils.isEmpty(text3) ? null : text3;
        a1Var.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(a1Var);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.A0.add(nVar);
        if (textInputLayout.f2992z != null) {
            nVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new y0(5, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(k9.h.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (com.bumptech.glide.c.z(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final q b() {
        q fVar;
        int i = this.D;
        o oVar = this.C;
        SparseArray sparseArray = (SparseArray) oVar.f10087c;
        q qVar = (q) sparseArray.get(i);
        if (qVar != null) {
            return qVar;
        }
        p pVar = (p) oVar.f10088d;
        if (i == -1) {
            fVar = new f(pVar, 0);
        } else if (i == 0) {
            fVar = new f(pVar, 1);
        } else if (i == 1) {
            fVar = new w(pVar, oVar.f10086b);
        } else if (i == 2) {
            fVar = new e(pVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(l0.e.g(i, "Invalid end icon mode: "));
            }
            fVar = new l(pVar);
        }
        sparseArray.append(i, fVar);
        return fVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.B;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.L.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f10090w.getVisibility() == 0 && this.B.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f10091x.getVisibility() == 0;
    }

    public final void f(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean z12;
        q qVarB = b();
        boolean zJ = qVarB.j();
        CheckableImageButton checkableImageButton = this.B;
        boolean z13 = true;
        if (!zJ || (z12 = checkableImageButton.f2921y) == qVarB.k()) {
            z11 = false;
        } else {
            checkableImageButton.setChecked(!z12);
            z11 = true;
        }
        if (!(qVarB instanceof l) || (zIsActivated = checkableImageButton.isActivated()) == ((l) qVarB).f10076l) {
            z13 = z11;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z10 || z13) {
            u8.a.y(this.f10089v, checkableImageButton, this.F);
        }
    }

    public final void g(int i) {
        if (this.D == i) {
            return;
        }
        q qVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.P;
        AccessibilityManager accessibilityManager = this.O;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.P = null;
        qVarB.r();
        this.D = i;
        Iterator it = this.E.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        h(i != 0);
        q qVarB2 = b();
        int iD = this.C.f10085a;
        if (iD == 0) {
            iD = qVarB2.d();
        }
        Drawable drawableI = iD != 0 ? j4.i(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.B;
        checkableImageButton.setImageDrawable(drawableI);
        TextInputLayout textInputLayout = this.f10089v;
        if (drawableI != null) {
            u8.a.b(textInputLayout, checkableImageButton, this.F, this.G);
            u8.a.y(textInputLayout, checkableImageButton, this.F);
        }
        int iC = qVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(qVarB2.j());
        if (!qVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        qVarB2.q();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = qVarB2.h();
        this.P = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.P);
        }
        View.OnClickListener onClickListenerF = qVarB2.f();
        View.OnLongClickListener onLongClickListener = this.J;
        checkableImageButton.setOnClickListener(onClickListenerF);
        u8.a.B(checkableImageButton, onLongClickListener);
        EditText editText = this.N;
        if (editText != null) {
            qVarB2.l(editText);
            j(qVarB2);
        }
        u8.a.b(textInputLayout, checkableImageButton, this.F, this.G);
        f(true);
    }

    public final void h(boolean z10) {
        if (d() != z10) {
            this.B.setVisibility(z10 ? 0 : 8);
            k();
            m();
            this.f10089v.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f10091x;
        checkableImageButton.setImageDrawable(drawable);
        l();
        u8.a.b(this.f10089v, checkableImageButton, this.f10092y, this.f10093z);
    }

    public final void j(q qVar) {
        if (this.N == null) {
            return;
        }
        if (qVar.e() != null) {
            this.N.setOnFocusChangeListener(qVar.e());
        }
        if (qVar.g() != null) {
            this.B.setOnFocusChangeListener(qVar.g());
        }
    }

    public final void k() {
        this.f10090w.setVisibility((this.B.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.K == null || this.M) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f10091x;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f10089v;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.F.f10118q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.D != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f10089v;
        if (textInputLayout.f2992z == null) {
            return;
        }
        this.L.setPaddingRelative(getContext().getResources().getDimensionPixelSize(k9.d.material_input_text_to_prefix_suffix_padding), textInputLayout.f2992z.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.f2992z.getPaddingEnd(), textInputLayout.f2992z.getPaddingBottom());
    }

    public final void n() {
        a1 a1Var = this.L;
        int visibility = a1Var.getVisibility();
        int i = (this.K == null || this.M) ? 8 : 0;
        if (visibility != i) {
            b().o(i == 0);
        }
        k();
        a1Var.setVisibility(i);
        this.f10089v.s();
    }
}
