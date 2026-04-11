package a9;

import android.media.MediaCodec;
import android.os.Build;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern f() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* synthetic */ PriorityQueue m(Comparator comparator) {
        return new PriorityQueue(comparator);
    }

    public static /* synthetic */ void x(c7.d dVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || dVar != ForkJoinPool.commonPool()) && !(zIsTerminated = dVar.isTerminated())) {
            dVar.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = dVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        dVar.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void y(ExecutorService executorService) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        executorService.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
