package i2;

import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f5987w;

    public /* synthetic */ d0(int i, Object obj) {
        this.f5986v = i;
        this.f5987w = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5986v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Handler) this.f5987w).post(runnable);
                break;
            default:
                y1.a0.S(((k4.b0) this.f5987w).f6916l, runnable);
                break;
        }
    }
}
