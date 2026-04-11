package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends SpannableStringBuilder {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Class f837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f838w;

    public b0(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f838w = new ArrayList();
        com.bumptech.glide.f.f(cls, "watcherClass cannot be null");
        this.f837v = cls;
    }

    public final void a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f838w;
            if (i >= arrayList.size()) {
                return;
            }
            ((a0) arrayList.get(i)).f836w.incrementAndGet();
            i++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f838w;
            if (i >= arrayList.size()) {
                return;
            }
            ((a0) arrayList.get(i)).onTextChanged(this, 0, length(), length());
            i++;
        }
    }

    public final a0 c(Object obj) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f838w;
            if (i >= arrayList.size()) {
                return null;
            }
            a0 a0Var = (a0) arrayList.get(i);
            if (a0Var.f835v == obj) {
                return a0Var;
            }
            i++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f837v == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i, int i10) {
        super.delete(i, i10);
        return this;
    }

    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f838w;
            if (i >= arrayList.size()) {
                return;
            }
            ((a0) arrayList.get(i)).f836w.decrementAndGet();
            i++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        a0 a0VarC;
        if (d(obj) && (a0VarC = c(obj)) != null) {
            obj = a0VarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        a0 a0VarC;
        if (d(obj) && (a0VarC = c(obj)) != null) {
            obj = a0VarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        a0 a0VarC;
        if (d(obj) && (a0VarC = c(obj)) != null) {
            obj = a0VarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i, int i10, Class cls) {
        if (this.f837v != cls) {
            return super.getSpans(i, i10, cls);
        }
        a0[] a0VarArr = (a0[]) super.getSpans(i, i10, a0.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, a0VarArr.length);
        for (int i11 = 0; i11 < a0VarArr.length; i11++) {
            objArr[i11] = a0VarArr[i11].f835v;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i10, Class cls) {
        if (cls == null || this.f837v == cls) {
            cls = a0.class;
        }
        return super.nextSpanTransition(i, i10, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        a0 a0VarC;
        if (d(obj)) {
            a0VarC = c(obj);
            if (a0VarC != null) {
                obj = a0VarC;
            }
        } else {
            a0VarC = null;
        }
        super.removeSpan(obj);
        if (a0VarC != null) {
            this.f838w.remove(a0VarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i10, CharSequence charSequence) {
        replace(i, i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i10, int i11) {
        if (d(obj)) {
            a0 a0Var = new a0(obj);
            this.f838w.add(a0Var);
            obj = a0Var;
        }
        super.setSpan(obj, i, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i10) {
        return new b0(this.f837v, this, i, i10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i, int i10) {
        super.delete(i, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i10, CharSequence charSequence, int i11, int i12) {
        replace(i, i10, charSequence, i11, i12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence, int i10, int i11) {
        super.insert(i, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i10, CharSequence charSequence) {
        a();
        super.replace(i, i10, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence, int i10, int i11) {
        super.insert(i, charSequence, i10, i11);
        return this;
    }

    public b0(Class cls, b0 b0Var, int i, int i10) {
        super(b0Var, i, i10);
        this.f838w = new ArrayList();
        com.bumptech.glide.f.f(cls, "watcherClass cannot be null");
        this.f837v = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i10, CharSequence charSequence, int i11, int i12) {
        a();
        super.replace(i, i10, charSequence, i11, i12);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i, int i10) {
        super.append(charSequence, i, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i, int i10) {
        super.append(charSequence, i, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i10) {
        super.append(charSequence, i, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
