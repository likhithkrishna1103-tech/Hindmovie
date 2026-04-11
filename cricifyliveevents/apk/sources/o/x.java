package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends MultiAutoCompleteTextView implements x0.k {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f9403y = {R.attr.popupBackground};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ff.k f9404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w0 f9405w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final z f9406x;

    /* JADX WARN: Illegal instructions before constructor call */
    public x(Context context, AttributeSet attributeSet) {
        int i = g.a.autoCompleteTextViewStyle;
        g3.a(context);
        super(context, attributeSet, i);
        f3.a(getContext(), this);
        l7.a aVarF = l7.a.F(getContext(), attributeSet, f9403y, i);
        if (((TypedArray) aVarF.f7867x).hasValue(0)) {
            setDropDownBackgroundDrawable(aVarF.u(0));
        }
        aVarF.G();
        ff.k kVar = new ff.k(this);
        this.f9404v = kVar;
        kVar.z(attributeSet, i);
        w0 w0Var = new w0(this);
        this.f9405w = w0Var;
        w0Var.f(attributeSet, i);
        w0Var.b();
        z zVar = new z(this);
        this.f9406x = zVar;
        zVar.b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerA = zVar.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            kVar.b();
        }
        w0 w0Var = this.f9405w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9405w.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9405w.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        w1.d.p(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.f9406x.c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9405w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9405w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(j4.i(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f9406x.d(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f9406x.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f9404v;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        w0 w0Var = this.f9405w;
        w0Var.l(colorStateList);
        w0Var.b();
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        w0 w0Var = this.f9405w;
        w0Var.m(mode);
        w0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w0 w0Var = this.f9405w;
        if (w0Var != null) {
            w0Var.g(context, i);
        }
    }
}
