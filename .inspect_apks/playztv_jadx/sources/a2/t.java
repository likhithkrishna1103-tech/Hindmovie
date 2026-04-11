package a2;

import android.util.Base64;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements z9.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f406u;

    @Override // z9.l
    public final Object get() {
        switch (this.f406u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new l();
            case 1:
                byte[] bArr = new byte[12];
                b2.j.i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
            case 2:
                try {
                    return Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
            case 3:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                if (executorServiceNewSingleThreadExecutor instanceof ea.z) {
                    return (ea.z) executorServiceNewSingleThreadExecutor;
                }
                return executorServiceNewSingleThreadExecutor instanceof ScheduledExecutorService ? new ea.d0((ScheduledExecutorService) executorServiceNewSingleThreadExecutor) : new ea.a0(executorServiceNewSingleThreadExecutor);
            default:
                throw new IllegalStateException();
        }
    }
}
