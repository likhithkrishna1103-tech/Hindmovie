package n;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends h0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8527h;
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f8528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ y0 f8529k;

    public s0(y0 y0Var, int i, int i10, WeakReference weakReference) {
        this.f8529k = y0Var;
        this.f8527h = i;
        this.i = i10;
        this.f8528j = weakReference;
    }

    @Override // h0.b
    public final void i(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f8527h) != -1) {
            typeface = x0.a(typeface, i, (this.i & 2) != 0);
        }
        y0 y0Var = this.f8529k;
        if (y0Var.f8583m) {
            y0Var.f8582l = typeface;
            TextView textView = (TextView) this.f8528j.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new t0(textView, typeface, y0Var.f8580j));
                } else {
                    textView.setTypeface(typeface, y0Var.f8580j);
                }
            }
        }
    }

    @Override // h0.b
    public final void h(int i) {
    }
}
