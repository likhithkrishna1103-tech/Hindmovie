package n;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends TextView implements u0.k {
    public Future A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f8366u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y0 f8367v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b0 f8368w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w f8369x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f8370y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a1 f8371z;

    public d1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private w getEmojiTextViewHelper() {
        if (this.f8369x == null) {
            this.f8369x = new w(this);
        }
        return this.f8369x;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        p pVar = this.f8366u;
        if (pVar != null) {
            pVar.b();
        }
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (u3.f8549c) {
            return super.getAutoSizeMaxTextSize();
        }
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
        return y0Var != null ? y0Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (u3.f8549c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            return y0Var.i.f8402a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.bumptech.glide.d.Z(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public z0 getSuperCaller() {
        if (this.f8371z == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.f8371z = new c1(this);
            } else if (i >= 28) {
                this.f8371z = new b1(this);
            } else if (i >= 26) {
                this.f8371z = new a1(this);
            }
        }
        return this.f8371z;
    }

    public ColorStateList getSupportBackgroundTintList() {
        p pVar = this.f8366u;
        if (pVar != null) {
            return pVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p pVar = this.f8366u;
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8367v.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8367v.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.A;
        if (future != null) {
            try {
                this.A = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                com.bumptech.glide.d.t(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        b0 b0Var;
        if (Build.VERSION.SDK_INT >= 28 || (b0Var = this.f8368w) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) b0Var.f8349c;
        return textClassifier == null ? r0.a((TextView) b0Var.f8348b) : textClassifier;
    }

    public o0.d getTextMetricsParamsCompat() {
        return com.bumptech.glide.d.t(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8367v.getClass();
        y0.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        i5.a.F(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        y0 y0Var = this.f8367v;
        if (y0Var == null || u3.f8549c) {
            return;
        }
        y0Var.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i10) {
        Future future = this.A;
        if (future != null) {
            try {
                this.A = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                com.bumptech.glide.d.t(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i10);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
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
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p pVar = this.f8366u;
        if (pVar != null) {
            pVar.q();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p pVar = this.f8366u;
        if (pVar != null) {
            pVar.r(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f8367v;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((i5.a) getEmojiTextViewHelper().f8559b.f12784v).t(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i);
        } else {
            com.bumptech.glide.d.L(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().a(i);
        } else {
            com.bumptech.glide.d.M(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        com.bumptech.glide.d.N(this, i);
    }

    public void setPrecomputedText(o0.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        com.bumptech.glide.d.t(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p pVar = this.f8366u;
        if (pVar != null) {
            pVar.y(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p pVar = this.f8366u;
        if (pVar != null) {
            pVar.z(mode);
        }
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        y0 y0Var = this.f8367v;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @Override // u0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        y0 y0Var = this.f8367v;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        b0 b0Var;
        if (Build.VERSION.SDK_INT >= 28 || (b0Var = this.f8368w) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            b0Var.f8349c = textClassifier;
        }
    }

    public void setTextFuture(Future<o0.e> future) {
        this.A = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(o0.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f9041b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(dVar.f9040a);
        setBreakStrategy(dVar.f9042c);
        setHyphenationFrequency(dVar.f9043d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z2 = u3.f8549c;
        if (z2) {
            super.setTextSize(i, f);
            return;
        }
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            i1 i1Var = y0Var.i;
            if (z2 || i1Var.f()) {
                return;
            }
            i1Var.g(i, f);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.f8370y) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            i5.a aVar = i0.g.f6168a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.f8370y = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f8370y = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c3.a(context);
        this.f8370y = false;
        this.f8371z = null;
        b3.a(getContext(), this);
        p pVar = new p(this);
        this.f8366u = pVar;
        pVar.n(attributeSet, i);
        y0 y0Var = new y0(this);
        this.f8367v = y0Var;
        y0Var.f(attributeSet, i);
        y0Var.b();
        b0 b0Var = new b0();
        b0Var.f8348b = this;
        this.f8368w = b0Var;
        getEmojiTextViewHelper().a(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            getSuperCaller().n(i, f);
        } else if (i10 >= 34) {
            q0.x.h(this, i, f);
        } else {
            com.bumptech.glide.d.N(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? com.bumptech.glide.d.p(context, i) : null, i10 != 0 ? com.bumptech.glide.d.p(context, i10) : null, i11 != 0 ? com.bumptech.glide.d.p(context, i11) : null, i12 != 0 ? com.bumptech.glide.d.p(context, i12) : null);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? com.bumptech.glide.d.p(context, i) : null, i10 != 0 ? com.bumptech.glide.d.p(context, i10) : null, i11 != 0 ? com.bumptech.glide.d.p(context, i11) : null, i12 != 0 ? com.bumptech.glide.d.p(context, i12) : null);
        y0 y0Var = this.f8367v;
        if (y0Var != null) {
            y0Var.b();
        }
    }
}
