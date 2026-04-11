package n;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u5.d f8559b;

    public w(TextView textView) {
        this.f8558a = textView;
        this.f8559b = new u5.d(textView);
    }

    public final void a(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f8558a.getContext().obtainStyledAttributes(attributeSet, g.j.AppCompatTextView, i, 0);
        try {
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            c(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(boolean z2) {
        ((i5.a) this.f8559b.f12784v).J(z2);
    }

    public final void c(boolean z2) {
        ((i5.a) this.f8559b.f12784v).L(z2);
    }
}
