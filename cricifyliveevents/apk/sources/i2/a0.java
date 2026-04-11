package i2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.LocaleList;
import android.view.PointerIcon;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a0 {
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern e(int i, int i10) {
        return new MediaCodec.CryptoInfo.Pattern(i, i10);
    }

    public static /* bridge */ /* synthetic */ LocaleList g(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ PointerIcon i(Object obj) {
        return (PointerIcon) obj;
    }

    public static /* synthetic */ void q() {
    }

    public static void s(ib.e eVar) {
        if ((Build.VERSION.SDK_INT <= 23 || eVar != ForkJoinPool.commonPool()) && !eVar.f6400v.isTerminated()) {
            eVar.shutdown();
            throw null;
        }
    }

    public static void t(ya.y yVar) {
        boolean zIsTerminated;
        ExecutorService executorService = yVar.f15018v;
        if ((Build.VERSION.SDK_INT <= 23 || yVar != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            yVar.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        yVar.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void u(ya.b0 b0Var) {
        boolean zIsTerminated;
        ExecutorService executorService = b0Var.f15018v;
        if ((Build.VERSION.SDK_INT <= 23 || b0Var != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            b0Var.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        b0Var.shutdownNow();
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
