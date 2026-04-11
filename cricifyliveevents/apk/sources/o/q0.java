package o;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends k0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f9325h;
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f9326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ w0 f9327k;

    public q0(w0 w0Var, int i, int i10, WeakReference weakReference) {
        this.f9327k = w0Var;
        this.f9325h = i;
        this.i = i10;
        this.f9326j = weakReference;
    }

    @Override // k0.b
    public final void i(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f9325h) != -1) {
            typeface = v0.a(typeface, i, (this.i & 2) != 0);
        }
        w0 w0Var = this.f9327k;
        if (w0Var.f9396m) {
            w0Var.f9395l = typeface;
            TextView textView = (TextView) this.f9326j.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new r0(textView, typeface, w0Var.f9393j));
                } else {
                    textView.setTypeface(typeface, w0Var.f9393j);
                }
            }
        }
    }

    @Override // k0.b
    public final void h(int i) {
    }
}
