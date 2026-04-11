package j2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements MediaCodec.OnFrameRenderedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u2.i f6669b;

    public /* synthetic */ b(m mVar, u2.i iVar, int i) {
        this.f6668a = i;
        this.f6669b = iVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j5, long j8) {
        switch (this.f6668a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u2.i iVar = this.f6669b;
                Handler handler = iVar.f12588u;
                if (Build.VERSION.SDK_INT >= 30) {
                    iVar.a(j5);
                } else {
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j5 >> 32), (int) j5));
                }
                break;
            default:
                u2.i iVar2 = this.f6669b;
                Handler handler2 = iVar2.f12588u;
                if (Build.VERSION.SDK_INT >= 30) {
                    iVar2.a(j5);
                } else {
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 0, (int) (j5 >> 32), (int) j5));
                }
                break;
        }
    }
}
