package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Executor {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ h f7260w = new h(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ h f7261x = new h(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7262v;

    public /* synthetic */ h(int i) {
        this.f7262v = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f7262v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
