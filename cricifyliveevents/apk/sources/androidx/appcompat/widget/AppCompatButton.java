package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import o.f1;
import o.f3;
import o.g3;
import o.u;
import o.w0;
import o.x3;
import w4.v;
import x0.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ff.k f544v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w0 f545w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public u f546x;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.buttonStyle);
    }

    private u getEmojiTextViewHelper() {
        if (this.f546x == null) {
            this.f546x = new u(this);
        }
        return this.f546x;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ff.k kVar = this.f544v;
        if (kVar != null) {
            kVar.b();
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (x3.f9409c) {
            return super.getAutoSizeMaxTextSize();
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            return Math.round(w0Var.i.f9213e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (x3.f9409c) {
            return super.getAutoSizeMinTextSize();
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            return Math.round(w0Var.i.f9212d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (x3.f9409c) {
            return super.getAutoSizeStepGranularity();
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            return Math.round(w0Var.i.f9211c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (x3.f9409c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        w0 w0Var = this.f545w;
        return w0Var != null ? w0Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (x3.f9409c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            return w0Var.i.f9209a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return v.v(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f544v;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f544v;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f545w.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f545w.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        w0 w0Var = this.f545w;
        if (w0Var == null || x3.f9409c) {
            return;
        }
        w0Var.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            f1 f1Var = w0Var.i;
            if (x3.f9409c || !f1Var.f()) {
                return;
            }
            f1Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i10, int i11, int i12) {
        if (x3.f9409c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i10, i11, i12);
            return;
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.i(i, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (x3.f9409c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.j(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (x3.f9409c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f544v;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f544v;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(v.w(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.f9386a.setAllCaps(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f544v;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f544v;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        w0 w0Var = this.f545w;
        w0Var.l(colorStateList);
        w0Var.b();
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        w0 w0Var = this.f545w;
        w0Var.m(mode);
        w0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            w0Var.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z10 = x3.f9409c;
        if (z10) {
            super.setTextSize(i, f);
            return;
        }
        w0 w0Var = this.f545w;
        if (w0Var != null) {
            f1 f1Var = w0Var.i;
            if (z10 || f1Var.f()) {
                return;
            }
            f1Var.g(i, f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g3.a(context);
        f3.a(getContext(), this);
        ff.k kVar = new ff.k(this);
        this.f544v = kVar;
        kVar.z(attributeSet, i);
        w0 w0Var = new w0(this);
        this.f545w = w0Var;
        w0Var.f(attributeSet, i);
        w0Var.b();
        getEmojiTextViewHelper().b(attributeSet, i);
    }
}
