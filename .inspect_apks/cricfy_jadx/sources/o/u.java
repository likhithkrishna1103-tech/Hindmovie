package o;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f9372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kf.i f9373b;

    public u(TextView textView) {
        this.f9372a = textView;
        this.f9373b = new kf.i(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((u8.a) this.f9373b.f7483w).s(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f9372a.getContext().obtainStyledAttributes(attributeSet, g.j.AppCompatTextView, i, 0);
        try {
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z10) {
        ((u8.a) this.f9373b.f7483w).z(z10);
    }

    public final void d(boolean z10) {
        ((u8.a) this.f9373b.f7483w).A(z10);
    }
}
