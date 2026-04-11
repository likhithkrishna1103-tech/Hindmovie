package da;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3570d;
    public final WeakReference f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ha.d f3572g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f3567a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f3568b = new z(0, this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3571e = true;

    public b0(a0 a0Var) {
        this.f = new WeakReference(null);
        this.f = new WeakReference(a0Var);
    }

    public final void a(String str) {
        TextPaint textPaint = this.f3567a;
        this.f3569c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f3570d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.f3571e = false;
    }

    public final void b(ha.d dVar, Context context) {
        if (this.f3572g != dVar) {
            this.f3572g = dVar;
            if (dVar != null) {
                TextPaint textPaint = this.f3567a;
                z zVar = this.f3568b;
                dVar.e(context, textPaint, zVar);
                a0 a0Var = (a0) this.f.get();
                if (a0Var != null) {
                    textPaint.drawableState = a0Var.getState();
                }
                dVar.d(context, textPaint, zVar);
                this.f3571e = true;
            }
            a0 a0Var2 = (a0) this.f.get();
            if (a0Var2 != null) {
                a0Var2.a();
                a0Var2.onStateChange(a0Var2.getState());
            }
        }
    }
}
