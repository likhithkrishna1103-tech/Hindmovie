package o;

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
import com.google.android.gms.internal.measurement.j4;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a1 extends TextView implements x0.k {
    public m2.e A;
    public Future B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ff.k f9173v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w0 f9174w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final z f9175x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u f9176y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9177z;

    public a1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private u getEmojiTextViewHelper() {
        if (this.f9176y == null) {
            this.f9176y = new u(this);
        }
        return this.f9176y;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            kVar.b();
        }
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (x3.f9409c) {
            return super.getAutoSizeMaxTextSize();
        }
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
        return w0Var != null ? w0Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (x3.f9409c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            return w0Var.i.f9209a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return w4.v.v(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public x0 getSuperCaller() {
        if (this.A == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.A = new z0(this);
            } else if (i >= 28) {
                this.A = new y0(this);
            } else if (i >= 26) {
                this.A = new m2.e(this);
            }
        }
        return this.A;
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9174w.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9174w.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.B;
        if (future != null) {
            try {
                this.B = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                w4.v.i(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f9175x) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) zVar.f9419c;
        return textClassifier == null ? p0.a((TextView) zVar.f9418b) : textClassifier;
    }

    public r0.c getTextMetricsParamsCompat() {
        return w4.v.i(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f9174w.getClass();
        w0.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        w1.d.p(editorInfo, inputConnectionOnCreateInputConnection, this);
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
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        w0 w0Var = this.f9174w;
        if (w0Var == null || x3.f9409c) {
            return;
        }
        w0Var.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i10) {
        Future future = this.B;
        if (future != null) {
            try {
                this.B = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                w4.v.i(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i10);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
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
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.k(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        w0 w0Var = this.f9174w;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().c(i);
        } else {
            w4.v.q(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().a(i);
        } else {
            w4.v.r(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        w4.v.s(this, i);
    }

    public void setPrecomputedText(r0.d dVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        w4.v.i(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f9173v;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        w0 w0Var = this.f9174w;
        w0Var.l(colorStateList);
        w0Var.b();
    }

    @Override // x0.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        w0 w0Var = this.f9174w;
        w0Var.m(mode);
        w0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        z zVar;
        if (Build.VERSION.SDK_INT >= 28 || (zVar = this.f9175x) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            zVar.f9419c = textClassifier;
        }
    }

    public void setTextFuture(Future<r0.d> future) {
        this.B = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(r0.c cVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = cVar.f10839b;
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
        getPaint().set(cVar.f10838a);
        setBreakStrategy(cVar.f10840c);
        setHyphenationFrequency(cVar.f10841d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z10 = x3.f9409c;
        if (z10) {
            super.setTextSize(i, f);
            return;
        }
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            f1 f1Var = w0Var.i;
            if (z10 || f1Var.f()) {
                return;
            }
            f1Var.g(i, f);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.f9177z) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            vf.g gVar = l0.g.f7609a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.f9177z = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f9177z = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g3.a(context);
        this.f9177z = false;
        this.A = null;
        f3.a(getContext(), this);
        ff.k kVar = new ff.k(this);
        this.f9173v = kVar;
        kVar.z(attributeSet, i);
        w0 w0Var = new w0(this);
        this.f9174w = w0Var;
        w0Var.f(attributeSet, i);
        w0Var.b();
        z zVar = new z();
        zVar.f9418b = this;
        this.f9175x = zVar;
        getEmojiTextViewHelper().b(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            getSuperCaller().d(i, f);
        } else if (i10 >= 34) {
            s.a.h(this, i, f);
        } else {
            w4.v.s(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? j4.i(context, i) : null, i10 != 0 ? j4.i(context, i10) : null, i11 != 0 ? j4.i(context, i11) : null, i12 != 0 ? j4.i(context, i12) : null);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? j4.i(context, i) : null, i10 != 0 ? j4.i(context, i10) : null, i11 != 0 ? j4.i(context, i11) : null, i12 != 0 ? j4.i(context, i12) : null);
        w0 w0Var = this.f9174w;
        if (w0Var != null) {
            w0Var.b();
        }
    }
}
