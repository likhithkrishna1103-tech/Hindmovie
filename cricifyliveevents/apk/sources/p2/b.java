package p2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements MediaCodec.OnFrameRenderedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y2.i f9885b;

    public /* synthetic */ b(l lVar, y2.i iVar, int i) {
        this.f9884a = i;
        this.f9885b = iVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j4, long j7) {
        switch (this.f9884a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                y2.i iVar = this.f9885b;
                Handler handler = iVar.f14667v;
                if (Build.VERSION.SDK_INT >= 30) {
                    iVar.a(j4);
                } else {
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j4 >> 32), (int) j4));
                }
                break;
            default:
                y2.i iVar2 = this.f9885b;
                Handler handler2 = iVar2.f14667v;
                if (Build.VERSION.SDK_INT >= 30) {
                    iVar2.a(j4);
                } else {
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 0, (int) (j4 >> 32), (int) j4));
                }
                break;
        }
    }
}
