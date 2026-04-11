package k1;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.media3.decoder.DecoderInputBuffer;
import h.l;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6787v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6788w;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        switch (this.f6787v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Runnable) this.f6788w).run();
                break;
            default:
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new l((Context) this.f6788w, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
                break;
        }
    }

    public /* synthetic */ b(Runnable runnable) {
        this.f6788w = runnable;
    }
}
