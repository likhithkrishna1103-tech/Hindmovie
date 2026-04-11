package j9;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f6913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f6914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6916d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6920j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Layout.Alignment f6917e = Layout.Alignment.ALIGN_NORMAL;
    public int f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6918g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6919h = 1;
    public boolean i = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextUtils.TruncateAt f6921k = null;

    public y(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f6913a = charSequence;
        this.f6914b = textPaint;
        this.f6915c = i;
        this.f6916d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f6913a == null) {
            this.f6913a = "";
        }
        int iMax = Math.max(0, this.f6915c);
        CharSequence charSequenceEllipsize = this.f6913a;
        int i = this.f;
        TextPaint textPaint = this.f6914b;
        if (i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f6921k);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f6916d);
        this.f6916d = iMin;
        if (this.f6920j && this.f == 1) {
            this.f6917e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f6917e);
        builderObtain.setIncludePad(this.i);
        builderObtain.setTextDirection(this.f6920j ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f6921k;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f);
        float f = this.f6918g;
        if (f != 1.0f) {
            builderObtain.setLineSpacing(0.0f, f);
        }
        if (this.f > 1) {
            builderObtain.setHyphenationFrequency(this.f6919h);
        }
        return builderObtain.build();
    }
}
