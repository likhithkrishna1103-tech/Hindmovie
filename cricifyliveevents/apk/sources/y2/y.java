package y2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Choreographer.FrameCallback, Handler.Callback {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final y f14746z = new y();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile long f14747v = -9223372036854775807L;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f14748w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Choreographer f14749x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14750y;

    public y() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i = y1.a0.f14551a;
        Handler handler = new Handler(looper, this);
        this.f14748w = handler;
        handler.sendEmptyMessage(1);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        this.f14747v = j4;
        Choreographer choreographer = this.f14749x;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            try {
                this.f14749x = Choreographer.getInstance();
            } catch (RuntimeException e9) {
                y1.b.q("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e9);
            }
            return true;
        }
        if (i == 2) {
            Choreographer choreographer = this.f14749x;
            if (choreographer != null) {
                int i10 = this.f14750y + 1;
                this.f14750y = i10;
                if (i10 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i != 3) {
            return false;
        }
        Choreographer choreographer2 = this.f14749x;
        if (choreographer2 != null) {
            int i11 = this.f14750y - 1;
            this.f14750y = i11;
            if (i11 == 0) {
                choreographer2.removeFrameCallback(this);
                this.f14747v = -9223372036854775807L;
            }
        }
        return true;
    }
}
