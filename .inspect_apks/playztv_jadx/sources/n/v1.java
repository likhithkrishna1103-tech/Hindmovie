package n;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8556u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ w1 f8557v;

    public /* synthetic */ v1(w1 w1Var, int i) {
        this.f8556u = i;
        this.f8557v = w1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8556u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ViewParent parent = this.f8557v.f8563x.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                w1 w1Var = this.f8557v;
                w1Var.a();
                View view = w1Var.f8563x;
                if (view.isEnabled() && !view.isLongClickable() && w1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    w1Var.A = true;
                    break;
                }
                break;
        }
    }
}
