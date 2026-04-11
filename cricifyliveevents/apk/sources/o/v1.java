package o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9379v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ w1 f9380w;

    public /* synthetic */ v1(w1 w1Var, int i) {
        this.f9379v = i;
        this.f9380w = w1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9379v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ViewParent parent = this.f9380w.f9400y.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                w1 w1Var = this.f9380w;
                w1Var.a();
                View view = w1Var.f9400y;
                if (view.isEnabled() && !view.isLongClickable() && w1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    w1Var.B = true;
                    break;
                }
                break;
        }
    }
}
