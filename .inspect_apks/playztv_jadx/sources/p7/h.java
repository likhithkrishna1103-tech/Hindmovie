package p7;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ h f10263v = new h(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ h f10264w = new h(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10265u;

    public /* synthetic */ h(int i) {
        this.f10265u = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f10265u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
