package da;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f3639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f3640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3642d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3647k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public kb.d f3649m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Layout.Alignment f3643e = Layout.Alignment.ALIGN_NORMAL;
    public int f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3644g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3645h = 1.0f;
    public int i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3646j = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f3648l = null;

    public y(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f3639a = charSequence;
        this.f3640b = textPaint;
        this.f3641c = i;
        this.f3642d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f3639a == null) {
            this.f3639a = "";
        }
        int iMax = Math.max(0, this.f3641c);
        CharSequence charSequenceEllipsize = this.f3639a;
        int i = this.f;
        TextPaint textPaint = this.f3640b;
        if (i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f3648l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f3642d);
        this.f3642d = iMin;
        if (this.f3647k && this.f == 1) {
            this.f3643e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f3643e);
        builderObtain.setIncludePad(this.f3646j);
        builderObtain.setTextDirection(this.f3647k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3648l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f);
        float f = this.f3644g;
        if (f != 0.0f || this.f3645h != 1.0f) {
            builderObtain.setLineSpacing(f, this.f3645h);
        }
        if (this.f > 1) {
            builderObtain.setHyphenationFrequency(this.i);
        }
        kb.d dVar = this.f3649m;
        if (dVar != null) {
            builderObtain.setBreakStrategy(((TextInputLayout) dVar.f7399w).P.getBreakStrategy());
        }
        return builderObtain.build();
    }
}
