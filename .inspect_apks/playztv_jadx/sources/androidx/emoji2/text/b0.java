package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Spannable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1166u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Spannable f1167v;

    public b0(Spannable spannable) {
        this.f1167v = spannable;
    }

    public final void a() {
        Spannable spannable = this.f1167v;
        if (!this.f1166u) {
            if ((Build.VERSION.SDK_INT < 28 ? new pa.b(3) : new a0(3)).i(spannable)) {
                this.f1167v = new SpannableString(spannable);
            }
        }
        this.f1166u = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f1167v.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f1167v.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f1167v.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f1167v.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f1167v.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f1167v.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i10, Class cls) {
        return this.f1167v.getSpans(i, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1167v.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i10, Class cls) {
        return this.f1167v.nextSpanTransition(i, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f1167v.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i10, int i11) {
        a();
        this.f1167v.setSpan(obj, i, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i10) {
        return this.f1167v.subSequence(i, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f1167v.toString();
    }
}
