package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class q extends CheckBox implements u0.j, u0.k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f8497u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f8498v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final y0 f8499w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w f8500x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c3.a(context);
        b3.a(getContext(), this);
        s sVar = new s(this);
        this.f8497u = sVar;
        sVar.e(attributeSet, i);
        p pVar = new p(this);
        this.f8498v = pVar;
        pVar.n(attributeSet, i);
        y0 y0Var = new y0(this);
        this.f8499w = y0Var;
        y0Var.f(attributeSet, i);
        getEmojiTextViewHelper().a(attributeSet, i);
    }

    private w getEmojiTextViewHelper() {
        if (this.f8500x == null) {
            this.f8500x = new w(this);
        }
        return this.f8500x;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p pVar = this.f8498v;
        if (pVar != null) {
            pVar.b();
        }
        y0 y0Var = this.f8499w;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        p pVar = this.f8498v;
        if (pVar != null) {
            return pVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p pVar = this.f8498v;
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    @Override // u0.j
    public ColorStateList getSupportButtonTintList() {
        s sVar = this.f8497u;
        if (sVar != null) {
            return (ColorStateList) sVar.f8522a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        s sVar = this.f8497u;
        if (sVar != null) {
            return (PorterDuff.Mode) sVar.f8523b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8499w.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8499w.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p pVar = this.f8498v;
        if (pVar != null) {
            pVar.q();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p pVar = this.f8498v;
        if (pVar != null) {
            pVar.r(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        s sVar = this.f8497u;
        if (sVar != null) {
            if (sVar.f8526e) {
                sVar.f8526e = false;
            } else {
                sVar.f8526e = true;
                sVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8499w;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8499w;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((i5.a) getEmojiTextViewHelper().f8559b.f12784v).t(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p pVar = this.f8498v;
        if (pVar != null) {
            pVar.y(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p pVar = this.f8498v;
        if (pVar != null) {
            pVar.z(mode);
        }
    }

    @Override // u0.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        s sVar = this.f8497u;
        if (sVar != null) {
            sVar.f8522a = colorStateList;
            sVar.f8524c = true;
            sVar.a();
        }
    }

    @Override // u0.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        s sVar = this.f8497u;
        if (sVar != null) {
            sVar.f8523b = mode;
            sVar.f8525d = true;
            sVar.a();
        }
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        y0 y0Var = this.f8499w;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        y0 y0Var = this.f8499w;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(com.bumptech.glide.d.p(getContext(), i));
    }
}
