package androidx.emoji2.text;

import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f848b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f849a;

    public e() {
        TextPaint textPaint = new TextPaint();
        this.f849a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
