package n;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends CheckedTextView implements u0.k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f8513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f8514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final y0 f8515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w f8516x;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int i = g.a.checkedTextViewStyle;
        c3.a(context);
        super(context, attributeSet, i);
        b3.a(getContext(), this);
        y0 y0Var = new y0(this);
        this.f8515w = y0Var;
        y0Var.f(attributeSet, i);
        y0Var.b();
        p pVar = new p(this);
        this.f8514v = pVar;
        pVar.n(attributeSet, i);
        this.f8513u = new s(this);
        kc.b bVarD = kc.b.D(getContext(), attributeSet, g.j.CheckedTextView, i);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        q0.o0.m(this, getContext(), g.j.CheckedTextView, attributeSet, (TypedArray) bVarD.f7621w, i);
        try {
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkCompat) && (resourceId2 = typedArray.getResourceId(g.j.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    setCheckMarkDrawable(com.bumptech.glide.d.p(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(g.j.CheckedTextView_android_checkMark)) {
                        setCheckMarkDrawable(com.bumptech.glide.d.p(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(g.j.CheckedTextView_android_checkMark) && (resourceId = typedArray.getResourceId(g.j.CheckedTextView_android_checkMark, 0)) != 0) {
                setCheckMarkDrawable(com.bumptech.glide.d.p(getContext(), resourceId));
            }
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkTint)) {
                setCheckMarkTintList(bVarD.q(g.j.CheckedTextView_checkMarkTint));
            }
            if (typedArray.hasValue(g.j.CheckedTextView_checkMarkTintMode)) {
                setCheckMarkTintMode(n1.b(typedArray.getInt(g.j.CheckedTextView_checkMarkTintMode, -1), null));
            }
            bVarD.E();
            getEmojiTextViewHelper().a(attributeSet, i);
        } catch (Throwable th) {
            bVarD.E();
            throw th;
        }
    }

    private w getEmojiTextViewHelper() {
        if (this.f8516x == null) {
            this.f8516x = new w(this);
        }
        return this.f8516x;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y0 y0Var = this.f8515w;
        if (y0Var != null) {
            y0Var.b();
        }
        p pVar = this.f8514v;
        if (pVar != null) {
            pVar.b();
        }
        s sVar = this.f8513u;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.bumptech.glide.d.Z(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        p pVar = this.f8514v;
        if (pVar != null) {
            return pVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p pVar = this.f8514v;
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        s sVar = this.f8513u;
        if (sVar != null) {
            return (ColorStateList) sVar.f8522a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        s sVar = this.f8513u;
        if (sVar != null) {
            return (PorterDuff.Mode) sVar.f8523b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8515w.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8515w.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        i5.a.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p pVar = this.f8514v;
        if (pVar != null) {
            pVar.q();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p pVar = this.f8514v;
        if (pVar != null) {
            pVar.r(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        s sVar = this.f8513u;
        if (sVar != null) {
            if (sVar.f8526e) {
                sVar.f8526e = false;
            } else {
                sVar.f8526e = true;
                sVar.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8515w;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8515w;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.bumptech.glide.d.a0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().c(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p pVar = this.f8514v;
        if (pVar != null) {
            pVar.y(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p pVar = this.f8514v;
        if (pVar != null) {
            pVar.z(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        s sVar = this.f8513u;
        if (sVar != null) {
            sVar.f8522a = colorStateList;
            sVar.f8524c = true;
            sVar.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        s sVar = this.f8513u;
        if (sVar != null) {
            sVar.f8523b = mode;
            sVar.f8525d = true;
            sVar.b();
        }
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        y0 y0Var = this.f8515w;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        y0 y0Var = this.f8515w;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y0 y0Var = this.f8515w;
        if (y0Var != null) {
            y0Var.g(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(com.bumptech.glide.d.p(getContext(), i));
    }
}
