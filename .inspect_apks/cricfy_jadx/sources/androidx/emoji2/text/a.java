package androidx.emoji2.text;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f834b;

    public /* synthetic */ a(int i, String str) {
        this.f833a = i;
        this.f834b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f833a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Thread thread = new Thread(runnable, this.f834b);
                thread.setPriority(10);
                return thread;
            default:
                return new Thread(runnable, this.f834b);
        }
    }
}
