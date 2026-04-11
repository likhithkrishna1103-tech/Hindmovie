package j9;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6839d;
    public final WeakReference f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n9.d f6841g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f6836a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b9.a f6837b = new b9.a(1, this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6840e = true;

    public a0(z zVar) {
        this.f = new WeakReference(null);
        this.f = new WeakReference(zVar);
    }

    public final void a(String str) {
        TextPaint textPaint = this.f6836a;
        this.f6838c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f6839d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.f6840e = false;
    }

    public final void b(n9.d dVar, Context context) {
        if (this.f6841g != dVar) {
            this.f6841g = dVar;
            if (dVar != null) {
                TextPaint textPaint = this.f6836a;
                b9.a aVar = this.f6837b;
                dVar.f(context, textPaint, aVar);
                z zVar = (z) this.f.get();
                if (zVar != null) {
                    textPaint.drawableState = zVar.getState();
                }
                dVar.e(context, textPaint, aVar);
                this.f6840e = true;
            }
            z zVar2 = (z) this.f.get();
            if (zVar2 != null) {
                zVar2.a();
                zVar2.onStateChange(zVar2.getState());
            }
        }
    }
}
