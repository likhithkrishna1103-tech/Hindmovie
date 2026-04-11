package v9;

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
import androidx.fragment.app.t0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import j9.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n.d1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends LinearLayout {
    public final CheckableImageButton A;
    public final q3.d B;
    public int C;
    public final LinkedHashSet D;
    public ColorStateList E;
    public PorterDuff.Mode F;
    public int G;
    public ImageView.ScaleType H;
    public View.OnLongClickListener I;
    public CharSequence J;
    public final d1 K;
    public boolean L;
    public EditText M;
    public final AccessibilityManager N;
    public nc.c O;
    public final k P;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextInputLayout f13370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FrameLayout f13371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CheckableImageButton f13372w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorStateList f13373x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PorterDuff.Mode f13374y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View.OnLongClickListener f13375z;

    public m(TextInputLayout textInputLayout, kc.b bVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.C = 0;
        this.D = new LinkedHashSet();
        this.P = new k(this);
        l lVar = new l(this);
        this.N = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f13370u = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f13371v = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, p8.f.text_input_error_icon);
        this.f13372w = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, p8.f.text_input_end_icon);
        this.A = checkableImageButtonA2;
        q3.d dVar = new q3.d();
        dVar.f10609c = new SparseArray();
        dVar.f10610d = this;
        int i = p8.l.TextInputLayout_endIconDrawable;
        TypedArray typedArray = (TypedArray) bVar.f7621w;
        dVar.f10607a = typedArray.getResourceId(i, 0);
        dVar.f10608b = typedArray.getResourceId(p8.l.TextInputLayout_passwordToggleDrawable, 0);
        this.B = dVar;
        d1 d1Var = new d1(getContext(), null);
        this.K = d1Var;
        int i10 = p8.l.TextInputLayout_errorIconTint;
        TypedArray typedArray2 = (TypedArray) bVar.f7621w;
        if (typedArray2.hasValue(i10)) {
            this.f13373x = a.a.j(getContext(), bVar, p8.l.TextInputLayout_errorIconTint);
        }
        if (typedArray2.hasValue(p8.l.TextInputLayout_errorIconTintMode)) {
            this.f13374y = f0.e(typedArray2.getInt(p8.l.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (typedArray2.hasValue(p8.l.TextInputLayout_errorIconDrawable)) {
            i(bVar.s(p8.l.TextInputLayout_errorIconDrawable));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(p8.j.error_icon_content_description));
        WeakHashMap weakHashMap = o0.f10475a;
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray2.hasValue(p8.l.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray2.hasValue(p8.l.TextInputLayout_endIconTint)) {
                this.E = a.a.j(getContext(), bVar, p8.l.TextInputLayout_endIconTint);
            }
            if (typedArray2.hasValue(p8.l.TextInputLayout_endIconTintMode)) {
                this.F = f0.e(typedArray2.getInt(p8.l.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (typedArray2.hasValue(p8.l.TextInputLayout_endIconMode)) {
            g(typedArray2.getInt(p8.l.TextInputLayout_endIconMode, 0));
            if (typedArray2.hasValue(p8.l.TextInputLayout_endIconContentDescription) && checkableImageButtonA2.getContentDescription() != (text = typedArray2.getText(p8.l.TextInputLayout_endIconContentDescription))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray2.getBoolean(p8.l.TextInputLayout_endIconCheckable, true));
        } else if (typedArray2.hasValue(p8.l.TextInputLayout_passwordToggleEnabled)) {
            if (typedArray2.hasValue(p8.l.TextInputLayout_passwordToggleTint)) {
                this.E = a.a.j(getContext(), bVar, p8.l.TextInputLayout_passwordToggleTint);
            }
            if (typedArray2.hasValue(p8.l.TextInputLayout_passwordToggleTintMode)) {
                this.F = f0.e(typedArray2.getInt(p8.l.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            g(typedArray2.getBoolean(p8.l.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            CharSequence text2 = typedArray2.getText(p8.l.TextInputLayout_passwordToggleContentDescription);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray2.getDimensionPixelSize(p8.l.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(p8.d.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.G) {
            this.G = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray2.hasValue(p8.l.TextInputLayout_endIconScaleType)) {
            ImageView.ScaleType scaleTypeF = i5.a.f(typedArray2.getInt(p8.l.TextInputLayout_endIconScaleType, -1));
            this.H = scaleTypeF;
            checkableImageButtonA2.setScaleType(scaleTypeF);
            checkableImageButtonA.setScaleType(scaleTypeF);
        }
        d1Var.setVisibility(8);
        d1Var.setId(p8.f.textinput_suffix_text);
        d1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        d1Var.setAccessibilityLiveRegion(1);
        d1Var.setTextAppearance(typedArray2.getResourceId(p8.l.TextInputLayout_suffixTextAppearance, 0));
        if (typedArray2.hasValue(p8.l.TextInputLayout_suffixTextColor)) {
            d1Var.setTextColor(bVar.q(p8.l.TextInputLayout_suffixTextColor));
        }
        CharSequence text3 = typedArray2.getText(p8.l.TextInputLayout_suffixText);
        this.J = TextUtils.isEmpty(text3) ? null : text3;
        d1Var.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(d1Var);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f3528y0.add(lVar);
        if (textInputLayout.f3525x != null) {
            lVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new t0(3, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(p8.h.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (a.a.y(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final n b() {
        n eVar;
        int i = this.C;
        q3.d dVar = this.B;
        SparseArray sparseArray = (SparseArray) dVar.f10609c;
        n nVar = (n) sparseArray.get(i);
        if (nVar != null) {
            return nVar;
        }
        m mVar = (m) dVar.f10610d;
        if (i == -1) {
            eVar = new e(mVar, 0);
        } else if (i == 0) {
            eVar = new e(mVar, 1);
        } else if (i == 1) {
            eVar = new t(mVar, dVar.f10608b);
        } else if (i == 2) {
            eVar = new d(mVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(e6.j.l("Invalid end icon mode: ", i));
            }
            eVar = new j(mVar);
        }
        sparseArray.append(i, eVar);
        return eVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.A;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap weakHashMap = o0.f10475a;
        return this.K.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f13371v.getVisibility() == 0 && this.A.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f13372w.getVisibility() == 0;
    }

    public final void f(boolean z2) {
        boolean z10;
        boolean zIsActivated;
        boolean z11;
        n nVarB = b();
        boolean zJ = nVarB.j();
        CheckableImageButton checkableImageButton = this.A;
        boolean z12 = true;
        if (!zJ || (z11 = checkableImageButton.f3458x) == nVarB.k()) {
            z10 = false;
        } else {
            checkableImageButton.setChecked(!z11);
            z10 = true;
        }
        if (!(nVarB instanceof j) || (zIsActivated = checkableImageButton.isActivated()) == ((j) nVarB).f13361l) {
            z12 = z10;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z2 || z12) {
            i5.a.H(this.f13370u, checkableImageButton, this.E);
        }
    }

    public final void g(int i) {
        if (this.C == i) {
            return;
        }
        n nVarB = b();
        nc.c cVar = this.O;
        AccessibilityManager accessibilityManager = this.N;
        if (cVar != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new r0.b(cVar));
        }
        this.O = null;
        nVarB.r();
        this.C = i;
        Iterator it = this.D.iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
        h(i != 0);
        n nVarB2 = b();
        int iD = this.B.f10607a;
        if (iD == 0) {
            iD = nVarB2.d();
        }
        Drawable drawableP = iD != 0 ? com.bumptech.glide.d.p(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.A;
        checkableImageButton.setImageDrawable(drawableP);
        TextInputLayout textInputLayout = this.f13370u;
        if (drawableP != null) {
            i5.a.b(textInputLayout, checkableImageButton, this.E, this.F);
            i5.a.H(textInputLayout, checkableImageButton, this.E);
        }
        int iC = nVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(nVarB2.j());
        if (!nVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        nVarB2.q();
        nc.c cVarH = nVarB2.h();
        this.O = cVarH;
        if (cVarH != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new r0.b(this.O));
            }
        }
        View.OnClickListener onClickListenerF = nVarB2.f();
        View.OnLongClickListener onLongClickListener = this.I;
        checkableImageButton.setOnClickListener(onClickListenerF);
        i5.a.M(checkableImageButton, onLongClickListener);
        EditText editText = this.M;
        if (editText != null) {
            nVarB2.l(editText);
            j(nVarB2);
        }
        i5.a.b(textInputLayout, checkableImageButton, this.E, this.F);
        f(true);
    }

    public final void h(boolean z2) {
        if (d() != z2) {
            this.A.setVisibility(z2 ? 0 : 8);
            k();
            m();
            this.f13370u.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f13372w;
        checkableImageButton.setImageDrawable(drawable);
        l();
        i5.a.b(this.f13370u, checkableImageButton, this.f13373x, this.f13374y);
    }

    public final void j(n nVar) {
        if (this.M == null) {
            return;
        }
        if (nVar.e() != null) {
            this.M.setOnFocusChangeListener(nVar.e());
        }
        if (nVar.g() != null) {
            this.A.setOnFocusChangeListener(nVar.g());
        }
    }

    public final void k() {
        this.f13371v.setVisibility((this.A.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.J == null || this.L) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f13372w;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f13370u;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.D.f13400q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.C != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int paddingEnd;
        TextInputLayout textInputLayout = this.f13370u;
        if (textInputLayout.f3525x == null) {
            return;
        }
        if (d() || e()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.f3525x;
            WeakHashMap weakHashMap = o0.f10475a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(p8.d.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f3525x.getPaddingTop();
        int paddingBottom = textInputLayout.f3525x.getPaddingBottom();
        WeakHashMap weakHashMap2 = o0.f10475a;
        this.K.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void n() {
        d1 d1Var = this.K;
        int visibility = d1Var.getVisibility();
        int i = (this.J == null || this.L) ? 8 : 0;
        if (visibility != i) {
            b().o(i == 0);
        }
        k();
        d1Var.setVisibility(i);
        this.f13370u.q();
    }
}
