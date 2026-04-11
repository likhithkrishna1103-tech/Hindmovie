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
import n.b3;
import n.c3;
import n.i1;
import n.p;
import n.u3;
import n.w;
import n.y0;
import u0.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f887u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y0 f888v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public w f889w;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.buttonStyle);
    }

    private w getEmojiTextViewHelper() {
        if (this.f889w == null) {
            this.f889w = new w(this);
        }
        return this.f889w;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        p pVar = this.f887u;
        if (pVar != null) {
            pVar.b();
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (u3.f8549c) {
            return super.getAutoSizeMaxTextSize();
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            return Math.round(y0Var.i.f8406e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (u3.f8549c) {
            return super.getAutoSizeMinTextSize();
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            return Math.round(y0Var.i.f8405d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (u3.f8549c) {
            return super.getAutoSizeStepGranularity();
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            return Math.round(y0Var.i.f8404c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (u3.f8549c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y0 y0Var = this.f888v;
        return y0Var != null ? y0Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (u3.f8549c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            return y0Var.i.f8402a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.bumptech.glide.d.Z(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        p pVar = this.f887u;
        if (pVar != null) {
            return pVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p pVar = this.f887u;
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f888v.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f888v.e();
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
    public void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        y0 y0Var = this.f888v;
        if (y0Var == null || u3.f8549c) {
            return;
        }
        y0Var.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            i1 i1Var = y0Var.i;
            if (u3.f8549c || !i1Var.f()) {
                return;
            }
            i1Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i10, int i11, int i12) {
        if (u3.f8549c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i10, i11, i12);
            return;
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.i(i, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (u3.f8549c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.j(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (u3.f8549c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p pVar = this.f887u;
        if (pVar != null) {
            pVar.q();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p pVar = this.f887u;
        if (pVar != null) {
            pVar.r(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.bumptech.glide.d.a0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((i5.a) getEmojiTextViewHelper().f8559b.f12784v).t(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z2) {
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.f8573a.setAllCaps(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p pVar = this.f887u;
        if (pVar != null) {
            pVar.y(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p pVar = this.f887u;
        if (pVar != null) {
            pVar.z(mode);
        }
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        y0 y0Var = this.f888v;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        y0 y0Var = this.f888v;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            y0Var.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z2 = u3.f8549c;
        if (z2) {
            super.setTextSize(i, f);
            return;
        }
        y0 y0Var = this.f888v;
        if (y0Var != null) {
            i1 i1Var = y0Var.i;
            if (z2 || i1Var.f()) {
                return;
            }
            i1Var.g(i, f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c3.a(context);
        b3.a(getContext(), this);
        p pVar = new p(this);
        this.f887u = pVar;
        pVar.n(attributeSet, i);
        y0 y0Var = new y0(this);
        this.f888v = y0Var;
        y0Var.f(attributeSet, i);
        y0Var.b();
        getEmojiTextViewHelper().a(attributeSet, i);
    }
}
