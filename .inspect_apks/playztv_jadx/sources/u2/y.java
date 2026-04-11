package u2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Choreographer.FrameCallback, Handler.Callback {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final y f12670y = new y();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f12671u = -9223372036854775807L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f12672v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Choreographer f12673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12674x;

    public y() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i = s1.b0.f11647a;
        Handler handler = new Handler(looper, this);
        this.f12672v = handler;
        handler.sendEmptyMessage(1);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) {
        this.f12671u = j5;
        Choreographer choreographer = this.f12673w;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            try {
                this.f12673w = Choreographer.getInstance();
            } catch (RuntimeException e10) {
                s1.b.q("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e10);
            }
            return true;
        }
        if (i == 2) {
            Choreographer choreographer = this.f12673w;
            if (choreographer != null) {
                int i10 = this.f12674x + 1;
                this.f12674x = i10;
                if (i10 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i != 3) {
            return false;
        }
        Choreographer choreographer2 = this.f12673w;
        if (choreographer2 != null) {
            int i11 = this.f12674x - 1;
            this.f12674x = i11;
            if (i11 == 0) {
                choreographer2.removeFrameCallback(this);
                this.f12671u = -9223372036854775807L;
            }
        }
        return true;
    }
}
