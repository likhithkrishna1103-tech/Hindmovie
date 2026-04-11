package c7;

import android.os.Process;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f2575v;

    public /* synthetic */ q(Runnable runnable, int i) {
        this.f2574u = i;
        this.f2575v = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2574u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    this.f2575v.run();
                } catch (Exception e10) {
                    cf.l.o("Executor", "Background execution failure.", e10);
                    return;
                }
                break;
            case 1:
                Process.setThreadPriority(10);
                this.f2575v.run();
                break;
            case 2:
                this.f2575v.run();
                break;
            default:
                Process.setThreadPriority(0);
                this.f2575v.run();
                break;
        }
    }

    public String toString() {
        switch (this.f2574u) {
            case 2:
                return this.f2575v.toString();
            default:
                return super.toString();
        }
    }
}
