package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends CheckedTextView implements x0.k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b5.e f9321v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ff.k f9322w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w0 f9323x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u f9324y;

    /* JADX WARN: Illegal instructions before constructor call */
    public q(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int i = g.a.checkedTextViewStyle;
        g3.a(context);
        super(context, attributeSet, i);
        f3.a(getContext(), this);
        w0 w0Var = new w0(this);
        this.f9323x = w0Var;
        w0Var.f(attributeSet, i);
        w0Var.b();
        ff.k kVar = new ff.k(this);
        this.f9322w = kVar;
        kVar.z(attributeSet, i);
        this.f9321v = new b5.e(this);
        l7.a aVarF = l7.a.F(getContext(), attributeSet, g.j.CheckedTextView, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        t0.m0.m(this, getContext(), g.j.CheckedTextView, attributeSet, (TypedArray) aVarF.f7867x, i);
        try {
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkCompat) && (resourceId2 = typedArray.getResourceId(g.j.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    setCheckMarkDrawable(j4.i(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(g.j.CheckedTextView_android_checkMark)) {
                        setCheckMarkDrawable(j4.i(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(g.j.CheckedTextView_android_checkMark) && (resourceId = typedArray.getResourceId(g.j.CheckedTextView_android_checkMark, 0)) != 0) {
                setCheckMarkDrawable(j4.i(getContext(), resourceId));
            }
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkTint)) {
                setCheckMarkTintList(aVarF.r(g.j.CheckedTextView_checkMarkTint));
            }
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkTintMode)) {
                setCheckMarkTintMode(n1.c(typedArray.getInt(g.j.CheckedTextView_checkMarkTintMode, -1), null));
            }
            aVarF.G();
            getEmojiTextViewHelper().b(attributeSet, i);
        } catch (Throwable th) {
            aVarF.G();
            throw th;
        }
    }

    private u getEmojiTextViewHelper() {
        if (this.f9324y == null) {
            this.f9324y = new u(this);
        }
        return this.f9324y;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w0 w0Var = this.f9323x;
        if (w0Var != null) {
            w0Var.b();
        }
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            kVar.b();
        }
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return w4.v.v(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            return (ColorStateList) eVar.f1789e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            return (PorterDuff.Mode) eVar.f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9323x.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9323x.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        w1.d.p(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            if (eVar.f1787c) {
                eVar.f1787c = false;
            } else {
                eVar.f1787c = true;
                eVar.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9323x;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9323x;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(w4.v.w(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f9322w;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            eVar.f1789e = colorStateList;
            eVar.f1785a = true;
            eVar.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        b5.e eVar = this.f9321v;
        if (eVar != null) {
            eVar.f = mode;
            eVar.f1786b = true;
            eVar.b();
        }
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        w0 w0Var = this.f9323x;
        w0Var.l(colorStateList);
        w0Var.b();
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        w0 w0Var = this.f9323x;
        w0Var.m(mode);
        w0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w0 w0Var = this.f9323x;
        if (w0Var != null) {
            w0Var.g(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(j4.i(getContext(), i));
    }
}
