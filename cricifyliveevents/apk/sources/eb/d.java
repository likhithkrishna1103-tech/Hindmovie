package eb;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;
import s7.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Executor {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ d f3885w = new d(0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3886v;

    public /* synthetic */ d(int i) {
        this.f3886v = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3886v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                runnable.run();
                break;
            case 1:
                new Thread(runnable).start();
                break;
            case 2:
                runnable.run();
                break;
            case 3:
                m.f().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
