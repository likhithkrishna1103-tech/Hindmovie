package j2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.LocaleList;
import android.view.PointerIcon;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern c() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern d(int i, int i10) {
        return new MediaCodec.CryptoInfo.Pattern(i, i10);
    }

    public static /* bridge */ /* synthetic */ LocaleList f(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ PointerIcon h(Object obj) {
        return (PointerIcon) obj;
    }

    public static /* synthetic */ PriorityQueue o(Comparator comparator) {
        return new PriorityQueue(comparator);
    }

    public static /* synthetic */ void p() {
    }

    public static void s(oa.e eVar) {
        if ((Build.VERSION.SDK_INT <= 23 || eVar != ForkJoinPool.commonPool()) && !eVar.f9467u.isTerminated()) {
            eVar.shutdown();
            throw null;
        }
    }
}
