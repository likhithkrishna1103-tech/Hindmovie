package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class p extends CheckBox implements x0.j, x0.k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b5.e f9300v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ff.k f9301w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w0 f9302x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u f9303y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g3.a(context);
        f3.a(getContext(), this);
        b5.e eVar = new b5.e(this);
        this.f9300v = eVar;
        eVar.e(attributeSet, i);
        ff.k kVar = new ff.k(this);
        this.f9301w = kVar;
        kVar.z(attributeSet, i);
        w0 w0Var = new w0(this);
        this.f9302x = w0Var;
        w0Var.f(attributeSet, i);
        getEmojiTextViewHelper().b(attributeSet, i);
    }

    private u getEmojiTextViewHelper() {
        if (this.f9303y == null) {
            this.f9303y = new u(this);
        }
        return this.f9303y;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            kVar.b();
        }
        w0 w0Var = this.f9302x;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    @Override // x0.j
    public ColorStateList getSupportButtonTintList() {
        b5.e eVar = this.f9300v;
        if (eVar != null) {
            return (ColorStateList) eVar.f1789e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        b5.e eVar = this.f9300v;
        if (eVar != null) {
            return (PorterDuff.Mode) eVar.f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9302x.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9302x.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        b5.e eVar = this.f9300v;
        if (eVar != null) {
            if (eVar.f1787c) {
                eVar.f1787c = false;
            } else {
                eVar.f1787c = true;
                eVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9302x;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9302x;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f9301w;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    @Override // x0.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        b5.e eVar = this.f9300v;
        if (eVar != null) {
            eVar.f1789e = colorStateList;
            eVar.f1785a = true;
            eVar.a();
        }
    }

    @Override // x0.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        b5.e eVar = this.f9300v;
        if (eVar != null) {
            eVar.f = mode;
            eVar.f1786b = true;
            eVar.a();
        }
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        w0 w0Var = this.f9302x;
        w0Var.l(colorStateList);
        w0Var.b();
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        w0 w0Var = this.f9302x;
        w0Var.m(mode);
        w0Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(j4.i(getContext(), i));
    }
}
