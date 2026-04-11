package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Spannable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f851v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Spannable f852w;

    public f0(Spannable spannable) {
        this.f852w = spannable;
    }

    public final void a() {
        Spannable spannable = this.f852w;
        if (!this.f851v) {
            if ((Build.VERSION.SDK_INT < 28 ? new ka.f(3) : new e0(3)).f(spannable)) {
                this.f852w = new SpannableString(spannable);
            }
        }
        this.f851v = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f852w.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f852w.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f852w.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f852w.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f852w.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f852w.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i10, Class cls) {
        return this.f852w.getSpans(i, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f852w.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i10, Class cls) {
        return this.f852w.nextSpanTransition(i, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f852w.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i10, int i11) {
        a();
        this.f852w.setSpan(obj, i, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i10) {
        return this.f852w.subSequence(i, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f852w.toString();
    }
}
