package p2;

import android.os.HandlerThread;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements ta.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9886v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f9887w;

    public /* synthetic */ c(int i, int i10) {
        this.f9886v = i10;
        this.f9887w = i;
    }

    @Override // ta.l
    public final Object get() {
        switch (this.f9886v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new HandlerThread(d.g(this.f9887w, "ExoPlayer:MediaCodecAsyncAdapter:"));
            default:
                return new HandlerThread(d.g(this.f9887w, "ExoPlayer:MediaCodecQueueingThread:"));
        }
    }
}
