package nb;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Number f9005b;

    public t() {
        this.f9004a = 1;
        this.f9005b = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f9004a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(new s(runnable));
                threadNewThread.setName("awaitEvenIfOnMainThread task continuation executor" + ((AtomicLong) this.f9005b).getAndIncrement());
                return threadNewThread;
            default:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + ((AtomicInteger) this.f9005b).getAndIncrement());
                return thread;
        }
    }

    public t(AtomicLong atomicLong) {
        this.f9004a = 0;
        this.f9005b = atomicLong;
    }
}
