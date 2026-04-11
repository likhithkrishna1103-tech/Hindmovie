package h;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5549u;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5549u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                new Thread(runnable).start();
                break;
            case 1:
                runnable.run();
                break;
            case 2:
                runnable.run();
                break;
            case 3:
                x6.m.f().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
