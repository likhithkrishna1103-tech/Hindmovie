package b2;

import android.util.Base64;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements ta.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1691v;

    @Override // ta.l
    public final Object get() {
        switch (this.f1691v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                if (executorServiceNewSingleThreadExecutor instanceof ya.x) {
                    return (ya.x) executorServiceNewSingleThreadExecutor;
                }
                return executorServiceNewSingleThreadExecutor instanceof ScheduledExecutorService ? new ya.b0((ScheduledExecutorService) executorServiceNewSingleThreadExecutor) : new ya.y(executorServiceNewSingleThreadExecutor);
            case 1:
                return new g2.j();
            case 2:
                byte[] bArr = new byte[12];
                h2.h.i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
            case 3:
                throw new IllegalStateException();
            default:
                try {
                    return Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                } catch (Exception e9) {
                    throw new IllegalStateException(e9);
                }
        }
    }
}
