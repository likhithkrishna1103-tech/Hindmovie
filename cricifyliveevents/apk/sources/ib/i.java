package ib;

import android.os.Process;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f6405w;

    public /* synthetic */ i(Runnable runnable, int i) {
        this.f6404v = i;
        this.f6405w = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6404v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6405w.run();
                break;
            case 1:
                Process.setThreadPriority(0);
                this.f6405w.run();
                break;
            case 2:
                try {
                    this.f6405w.run();
                } catch (Exception e9) {
                    vf.g.x("Executor", "Background execution failure.", e9);
                    return;
                }
                break;
            default:
                Process.setThreadPriority(10);
                this.f6405w.run();
                break;
        }
    }

    public String toString() {
        switch (this.f6404v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f6405w.toString();
            default:
                return super.toString();
        }
    }
}
